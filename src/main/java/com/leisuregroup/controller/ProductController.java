package com.leisuregroup.controller;

import com.leisuregroup.dto.Product;
import com.leisuregroup.repository.CategoryRepository;
import com.leisuregroup.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductController(final ProductRepository productRepository, final CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }


    @PostMapping
    public ResponseEntity createProduct(@RequestBody Product product) throws URISyntaxException {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.created(new URI("/products/" + savedProduct.getId())).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product currentProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
        currentProduct.setName(product.getName());
        currentProduct = productRepository.save(product);

        return ResponseEntity.ok(currentProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
