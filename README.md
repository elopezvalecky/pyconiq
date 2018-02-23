# Payconiq Assignment


## Goal 


### Application
We would like you to create a java based backend application using REST.
It should contain the following endpoints;

*GET /api/stocks*​ (get a list of stocks)
*POST /api/stocks*​ (create a stock)
*GET /api/stocks/1​* (get one stock from the list)
*PUT /api/stocks/1*​ (update the price of a single stock)

The list of stocks should be created in memory on application startup.
The stock object contains at least the fields; id (Number), name (String), currentPrice (Amount) and lastUpdate (Timestamp).
Use the frameworks as you see fit to build and test this.

### Nice to have
We would also like you to create a front-end which shows the stock list.

*NOTE:*​ Please do not use a generator (like yeoman), because then it is very difficult for us to determine what you have written yourself and what parts are generated.

### Implementation
Treat this application as a real MVP that should go to production.

------

## Components

- Backend
	- Java 8
	- Spring Boot
	- Spring Cloud
	  - Eureka
	  - Zuul
	
- Frontend
  - Nodejs v8.9.4
	- [Nuxt](https://nuxtjs.org/)

## Introduction

This project is divide in 4 subproject
  - service-discovery (based on Eureka) `Java`
  - api-gateway (based on Zuul) `Java`
  - stock-service `Java`
  - web-app `Nodejs`
  
The main reason of this configuration is to show how a microservice oriented architecture should be and how it work, also keeping in mind the goal of this assignment.

It provides an embedded HSQLDB database as in-memory database
Also, under the stock-service project you will find a swagger.json file that has the specification of the Rest-API

## How to Use

Checkout this respository

Open 4 terminals

- Service discovery
  1. `$ cd service-discovery`
  2. `$ mvn spring-boot:run`

- API Gateway
  1. `$ cd api-gateway`
  2. `$ mvn spring-boot:run`

- Stock Service
  1. `$ cd stock-service`
  2. `$ mvn spring-boot:run`

- WebApp
  1. `$ cd web-app`
  2. `$ npm run dev`
  3. Open in browser the url displayed in the console to access the wep-app interface


## How to Deploy

- For java project you can run `$ mvn package` in the root directory of the project, it will generate the respective JAR's for each subproject under the directory `target/` of each java project
  There is not a specific mechanims to upload the packages to an Artifactory, it can be to a maven repository or wrapped into a docker image.
  To run the respective modules is enough to execute `$ java -jar {path-to-jar}.jar` for example from the root `$ java -jar service-discovery/target/payconiq-service-discovery-1.0.0.jar`

- For nodejs project:
  1. `$ cd web-app`
  2. `$ npm run start` to run the server from the source code
    OR
     `$ npm run generate` to generate static content under `dist/` directory to upload to a static hosting.
 
## Known Issues

- Location Header points to the actual service address instead of the proxy (api-gateway)


## To Do

- Pagination in the webapp. 
- Proper deployment configuration for Continious Delivery (CD), like automatic docker image generation.


