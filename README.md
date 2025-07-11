# Employee Management System

A **Full-Stack Employee Management System** built using **Spring Boot (Backend)** and **HTML/CSS/JavaScript (Frontend)**.  
This project allows users to perform **CRUD operations** (Create, Read, Update, Delete) on employee data via a RESTful API.

---

## 📂 Project Structure

Employee-Management-System/
│
├── frontend/ # Frontend - HTML, CSS, JS
│ ├── index.html
│ ├── style.css
│ └── script.js
│
├── Employee/ # Backend - Spring Boot Application
│ ├── src/
│ ├── pom.xml
│ └── ...


---

## 🧰 Technologies Used

### 🔧 Backend
- Java 21+
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

### 🎨 Frontend
- HTML5
- CSS3
- JavaScript

---

## 🚀 Features

- Add new employees
- View all employees
- Update existing employee details
- Delete employees
- Fully RESTful APIs
- Simple and clean frontend

---

## 🔗 API Endpoints

| Method | Endpoint               | Description             |
|--------|------------------------|-------------------------|
| GET    | `/api/employees`       | Get all employees       |
| GET    | `/api/employees/{id}`  | Get employee by ID      |
| POST   | `/api/employees`       | Add new employee        |
| PUT    | `/api/employees/{id}`  | Update employee         |
| DELETE | `/api/employees/{id}`  | Delete employee         |

---

## 🛠️ Setup Instructions

### 🖥 Backend (Spring Boot)

1. Clone the repository:
   ```bash
   git clone https://github.com/pratiktekanar/Employee-Management-System.git
   cd Employee-Management-System/Employee

2.Configure database in src/main/resources/application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/employees_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update


3.Build and run the Spring Boot app:
mvn spring-boot:run


##Frontend (HTML/CSS/JS)
1.Open frontend/index.html in a browser

2.Make sure the backend (http://localhost:8080) is running

3.All actions (Add, Update, Delete) will sync with backend

<img width="1905" height="930" alt="Screenshot 2025-07-11 195756" src="https://github.com/user-attachments/assets/aab20b15-5205-4bc4-936b-08e2a4d5c5e0" />

<img width="1911" height="925" alt="Screenshot 2025-07-11 195917" src="https://github.com/user-attachments/assets/d64d65c5-ba13-4e7a-9c6e-8e4d2aed5b22" />

<img width="1901" height="927" alt="Screenshot 2025-07-11 195958" src="https://github.com/user-attachments/assets/47d87d23-ce4c-449b-9173-ede776078f3a" />


