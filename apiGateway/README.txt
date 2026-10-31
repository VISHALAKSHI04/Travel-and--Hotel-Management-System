API Gateway Project

Port:
8085

Eureka Server:
http://localhost:8761/eureka/

Routes:
1. Student service
   GET http://localhost:8085/api/student/**
   Load-balanced service name: student-service

2. Course service
   GET http://localhost:8085/api/courses/**
   Load-balanced service name: course-service

Run:
mvn spring-boot:run

Note:
Start Eureka Server, student-service, and course-service before testing the gateway.
