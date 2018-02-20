# Payconiq Assessment


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
	- [Nuxt](https://nuxtjs.org/)


## How to Use

TODO
 
## How to Deploy

TODO 
 
## Known Issues

- Location Header points to the actual service address instead of the proxy (api-gateway)


## To Do

- Pagination in the webapp. 


