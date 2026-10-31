# Hotel Service

Spring Boot Hotel Microservice with:
- Spring Web
- Spring Data JPA
- MySQL
- Eureka Client
- CRUD REST APIs

## 1. Create MySQL database

```sql
CREATE DATABASE hoteldb;
```

If your MySQL password is not `root`, change it in:
`src/main/resources/application.properties`

## 2. Start Eureka Server

Run your Eureka Server first on:
`http://localhost:8761`

If you don't use Eureka, remove the Eureka dependency and Eureka properties.

## 3. Run Hotel Service

Run:
`HotelServiceApplication.java`

The service runs on:
`http://localhost:8083`

## 4. API endpoints

POST   /hotels
GET    /hotels
GET    /hotels/{id}
PUT    /hotels/{id}
DELETE /hotels/{id}

## Sample POST JSON

```json
{
  "name": "Sea View Hotel",
  "location": "Chennai",
  "type": "Luxury",
  "pricePerNight": 3500
}
```

## Sample PUT JSON

```json
{
  "name": "Updated Sea View Hotel",
  "location": "Chennai",
  "type": "Premium",
  "pricePerNight": 4500
}
```
