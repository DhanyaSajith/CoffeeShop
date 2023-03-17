
# CoffeeShop Backend API
This is a backend API for online Coffeeshop, where users can place drinks with toppings orders and admins can create/update/delete drinks/toppings and have access to the most used toppings. Also, there will be a discount program for the clients that order more than average.  The API is built using Java and Spring Boot.

## Requirements
Java 11 or later
Maven
# Getting Started
## Clone the repository:
git clone https://github.com/DhanyaSajith/CoffeeShop
## Build the project:
mvn clean install
## Start the application:
mvn spring-boot:run
The application will start running at http://localhost:8080

# API Endpoints
The API endpoints can be accessed at http://localhost:8080/api

## Drinks
GET /drinks: Get all drinks

POST /drinks: Create a new drink

PUT /drinks/{id}: Update an existing drink

DELETE /drinks/{id}: Delete an existing drink

## Toppings

GET /toppings: Get all toppings

POST /toppings: Create a new topping

PUT /toppings/{id}: Update an existing topping

DELETE /toppings/{id}: Delete an existing topping

# Data Models
The API uses the following data models:

## Drink

id (long): The ID of the drink

name (string): The name of the drink

price (double): The price of the drink

toppings (list of Drink Topping): The toppings of the drink

## Topping

id (long): The ID of the topping

name (string): The name of the topping

price (double): The price of the topping

drinks (list of Drink Topping): The drinks that use the topping

## Drink Topping

id (long): The ID of the drink topping

drink (Drink): The drink that uses the topping

topping (Topping): The topping used by the drink
