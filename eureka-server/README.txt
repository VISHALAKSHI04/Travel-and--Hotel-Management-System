EUREKA SERVER

Package:
com.example.eureka_server

Application:
EurekaServerApplication

Port:
8761

Eureka Dashboard:
http://localhost:8761/

Configuration:
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

This server is the service registry for:
- course-service
- student-service
- api-gateway

Run:
mvn spring-boot:run

Start this Eureka Server first, then start the microservices and API Gateway.
