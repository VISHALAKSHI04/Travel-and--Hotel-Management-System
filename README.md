🏨 Travel and Hotel Management System

A web-based Travel and Hotel Management System built with a **microservices architecture**. Users can browse hotels and rooms, book stays, make payments and leave reviews. Admins can manage the whole system.

 🛠️ Tech Stack

| Layer | Technology |
|-------|-----------|
| Frontend | HTML, CSS, JavaScript |
| Backend | Java, Spring Boot |
| API Gateway | Spring Cloud Gateway |
| Database | MySQL |
| Build Tool | Maven |

📁 Project Structure

```
Travel-and--Hotel-Management-System/
├── Frontend/KodaiMistResort/   # UI pages (login, rooms, booking, payment, admin)
├── apiGateway/                 # Single entry point for all requests
├── booking-service/            # Booking management
├── room-service/               # Room details and availability
└── userservice/                # User registration and login
```

✨ Features

- User registration and login
- Admin login and admin dashboard
- Hotel and room listing
- Room booking
- Payment page
- Reviews and notifications
- Gallery and experiences pages

🚀 How to Run

1. Clone the repositorybash
   git clone https://github.com/VISHALAKSHI04/Travel-and--Hotel-Management-System.git
2. Start `userservice`, `room-service` and `booking-service`
3. Start `apiGateway`
4. Open `Frontend/KodaiMistResort/index.html` in your browser

👩‍💻 Author

k.Vishalakshi
- GitHub: [VISHALAKSHI04](https://github.com/VISHALAKSHI04)
- LinkedIn: [Vishalakshi K](https://linkedin.com/in/vishalakshi-k-1b3b55285)
