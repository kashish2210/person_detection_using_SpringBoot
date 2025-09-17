# Spring Boot Login & Camera Detection App

A complete Spring Boot application featuring user authentication with PostgreSQL database integration and real-time camera object detection using TensorFlow.js.

## Features

-  User Registration & Login
-  PostgreSQL Database Integration
-  Responsive UI with Bootstrap
-  Real-time Camera Object Detection
-  TensorFlow.js COCO-SSD Model Integration

## Prerequisites

### Java Installation
Check your Java version:
```bash
java -version
```
**Required:** Java 17+ (Spring Boot compatibility)

### PostgreSQL Setup
Ensure PostgreSQL is installed and running on your system.

## Quick Start

### 1. Database Configuration

Create the database:
```sql
CREATE DATABASE loginapp;
```

Configure `src/main/resources/application.properties`:
```properties
spring.application.name=login

# PostgreSQL Database Config
spring.datasource.url=jdbc:postgresql://localhost:5432/loginapp
spring.datasource.username=your_postgres_user
spring.datasource.password=your_postgres_password

# JPA (Hibernate) settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

**Replace:**
- `your_postgres_user` → Your PostgreSQL username (typically `postgres`)
- `your_postgres_password` → Your PostgreSQL password

### 2. Run the Application

```bash
mvnw.cmd spring-boot:run
```

### 3. Access the Application

Open your browser and navigate to: **http://localhost:8080**

## Application Flow

1. **Registration** → Create a new user account
2. **Login** → Authenticate with credentials
3. **Welcome Page** → Access granted with username display
4. **Camera Detection** → Click button to launch object detection

## Project Structure

```
src/
├── main/
│   ├── java/com/example/login/
│   │   ├── controller/AuthController.java
│   │   ├── model/User.java
│   │   └── repository/UserRepository.java
│   ├── resources/
│   │   ├── templates/
│   │   │   ├── login.html
│   │   │   ├── register.html
│   │   │   └── welcome.html
│   │   ├── static/
│   │   │   └── camera.html
│   │   └── application.properties
```

## Key Components

### Authentication Controller
- Handles login/register requests
- User validation and session management
- Redirects to welcome page on successful login

### Database Integration
- PostgreSQL with JPA/Hibernate
- Automatic table creation (`ddl-auto=update`)
- User entity with username/password fields

### Camera Detection
- Real-time video stream processing
- TensorFlow.js COCO-SSD model
- Object detection with bounding boxes
- Confidence score display

## Technologies Used

- **Backend:** Spring Boot, Spring Data JPA
- **Database:** PostgreSQL
- **Frontend:** Thymeleaf, Bootstrap 5
- **AI/ML:** TensorFlow.js, COCO-SSD
- **Styling:** Bootstrap Dark Theme

## Troubleshooting

### Database Connection Issues
- Verify PostgreSQL service is running
- Check database credentials in `application.properties`
- Ensure `loginapp` database exists

### Camera Access Problems
- Allow camera permissions in browser
- Use HTTPS for production environments
- Check browser compatibility for MediaDevices API

### Port Conflicts
Default port is 8080. To change:
```properties
server.port=8081
```

## Security Notes

⚠ **Development Only:** This implementation uses plain text passwords. For production:
- Implement password hashing (BCrypt)
- Add CSRF protection
- Use HTTPS encryption
- Implement proper session management

## Browser Compatibility

- Chrome 60+
- Firefox 55+
- Safari 11+
- Edge 79+

## License

This project is for educational purposes.
