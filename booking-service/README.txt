BOOKING SERVICE

1. Import this ZIP into Eclipse:
   File -> Import -> Maven -> Existing Maven Projects
   Select the extracted booking-service folder.
   Finish.

2. Open:
   src/main/resources/application.properties

3. Change:
   spring.datasource.password=YOUR_MYSQL_PASSWORD

4. Make sure MySQL has:
   CREATE DATABASE travel_db;

5. Start Eureka Server first:
   http://localhost:8761

6. Run:
   BookingServiceApplication.java
   It will run on port 8089.

POSTMAN TESTS

Create booking:
POST http://localhost:8089/bookings

JSON:
{
  "userId": 1,
  "hotelId": 1,
  "roomId": 1,
  "checkIn": "2026-10-10",
  "checkOut": "2026-10-12",
  "guestName": "Asmin",
  "guestEmail": "asmin@gmail.com"
}

Get all:
GET http://localhost:8089/bookings

Get one:
GET http://localhost:8089/bookings/1

User bookings:
GET http://localhost:8089/bookings/user/1

Admin pending:
GET http://localhost:8089/bookings/pending

Admin confirm:
PUT http://localhost:8089/bookings/1/confirm

Admin reject:
PUT http://localhost:8089/bookings/1/reject

Gateway URL after adding the gateway route:
http://localhost:8080/api/bookings
