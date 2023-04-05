
# Restaurant Simple Management System

Simple implementation to Spring Boot Rest API with JWT-based authentication and role-based authorization

## Features

* Authentication system with role-based authorization
* 3 Roles seeded to DB on initial run (ADMIN-EDITOR-USER)
* Add Restaurant, Category, Ad
* Support Cuisine types
* Add images to category and Ad
* Upload file to File System 
* Search Restaurants on multiple fields
* Filter Restaurants list on multiple fields
* Pagination on all resources endpoints for better performance

## TEST
* Added JUnit test on Add Restaurant endpoint

## How to use
1. Clone the repository with git clone
2. Download dependencies
3. Modify application.properties to meet your environment
4. Start the application

That's it

## Frameworks
* Spring Boot 2.7.3


## Todo
* Complete CRUD on all entities
* improve filter on restaurant location
* Add TEST for all endpoints
* using @Cacheable on needed endpoints to improve performance.
* ....

## Authors

- [@hyb90](https://github.com/hyb90)