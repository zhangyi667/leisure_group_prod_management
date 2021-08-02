## Prerequisites:
* Java 8
* Maven
* npm

Once cloned the project, open it in your ide.

Make sure the port defined in application.properties and package.json are same.

In the project directory, you can run:
### `npm start`

Runs the front end in the development mode.

Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

In the back end either start the project using ide, or run 

### `mvn spring-boot:run`



## Brief introduction of this project
This is more like a prototype rather than a project.\
The backend is SpringBoot + Hibernate, and front end is React.
The reason I chose these tech specs is that, Hibernates enables a in-memory database itself so that you don't need to 
worry about what type of database to use in order to run it. And with SpringBoot handling most of the work, I can just write
a controller to make it work.\
TBH I'm not familiar with React, but since you're using it and I've been using Angular and Marionette + Backbone,
I thought it would not be very difficult to figure out the code. But I think I underestimated the work.

Overall, this project has such features:
* Add a product
* Delete a product
* Edit a product
* List all products with its name and description
* Filter the products by its name

And what this product doesn't contain:
* User can't sort by name.
* It doesn't show Category. In fact, it's only defined in backend.
* No field of createDate, lastPurchasedDate and updateDate of product
* No paging results

Some explanation:
* The reason for not having a sort - I think I can implement a sort function just like the way I implement filter, but I've
checked the document and it suggests to use React-Table with useSortBy, so I tried but didn't figure out how to use it. I found 
it not interesting if I couldn't implement it in React way so I just didn't do it.

* The reason for no Category - This is actually a backend issue. In theory Product and Category should have a relation N:1, 
and since I haven't worked on hibernate for some time I forgot the syntax to define a Many-To-One relation. Had I got more time
this would not be a problem.

* Not rendering dates - Same time reason.

* No paging results - this is actually same with sorting that I haven't figure out the react way to do it.


