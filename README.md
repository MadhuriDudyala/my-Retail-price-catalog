
This application interacts with the Mongodb(NOSQL) store to fetch and save the pricing information for a product using Spring Boot Framework. 

Technology:
This is implemented in Spring boot framework along with Spring data framework in the persistence layer. 
In this we are starting the embeded tomcat sever and embeded mongodb database.
This project has 2 parts in it.They are developed using MicroServices Architecture with API Gateway design pattern.
myRetail-API-Gateway gets the request from the client for retreiving the product information from multiple sources.
and myRetail-Price-catalog is responsible for data access operations.

Prerequisites:

1) Install Eclipse (Neon)
2) Install Spring Tool Suite (STS) plugin for eclipse (http://dist.springsource.com/release/TOOLS/update/e4.6/)
3) We need to make sure both projects are running on different ports.For this my-Retail-price-catalog we are running it on 9001 and myRetail-API-Gateway will run on 8080 port 
   We can change it by providing -Dserver.port=9001 as VM argument.
4) Install Mongodb compass client for interacting with the Nosql database
5) Install rest client for hitting the service endpoints ( PostMan)

Run the Application:
1) Right Click on my-Retail-price-catalog and run as Spring Boot App. This will start the tomcat on 9001 port and mongodb.
Note : Please copy the port number from the console on which mongodb is listening.
2) POST Request - 
 Create product information 
 Endpoint : localhost:9001
 Payload :  {
  "id": 13860428,
  "value": 13.49,
  "currency_code": "USD"
 }
3) Right click on myRetail-api-gateway and run as Spring Boot App.This will start the tomcat server on 8080.
4) GET Request -
 Gets the product information
 Endpoint : localhost:8080/products/13860428
5) Put Request - 
 Update the product price
 Endpoint : localhost:8080/products/13860428
 Payload : {
  "id": 13860428,
  "name": "The Big Lebowski (Blue-ray) (Widescreen)",
  "current_price": {
    "value": 77.49,
    "currency_code": "USD"
  }
 }





