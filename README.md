# ClassMate Backend

ClassMate is a containerized microservices-based backend system designed to
support student academic planning, task management, grade tracking, and reminders.

The backend follows modern Spring Boot microservice architecture principles,
with database-per-service isolation, API Gateway routing, and containerized deployment.

---

## Architecture Overview

- Microservices architecture
- API Gateway for routing and versioning
- Database per service
- Docker Compose for local orchestration
- Flyway for PostgreSQL migrations
- Testcontainers for integration testing

Services:
- API Gateway
- Course Service (PostgreSQL)
- Grade Service (PostgreSQL)
- Task Service (MongoDB)
- Reminder Service (MongoDB)

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Cloud Gateway
- PostgreSQL
- MongoDB
- Flyway
- Docker & Docker Compose
- JUnit 5
- Testcontainers
- Gradle

---

## Prerequisites

Ensure the following are installed:

- Java 21+
- Docker & Docker Compose
- Gradle (or use `./gradlew`)
- Git

---

## Build & Run (Docker)

From the project root:

```bash

docker compose up -d --build

1. Verify containers are running:

docker ps

2. Running Tests
Run all unit and integration tests:

./gradlew test

Integration tests automatically spin up Postgres and MongoDB using Testcontainers.

3. API Gateway Endpoints
All services are accessed through the API Gateway:

Service	Endpoint
Courses	/api/v1/courses
Grades	/api/v1/grades
Tasks	/api/v1/tasks
Reminders	/api/v1/reminders

4. Smoke Test Examples

curl http://localhost:8080/api/v1/courses
curl http://localhost:8080/api/v1/tasks

5. Project Structure

classmate-backend/
├── api-gateway/
├── course-service/
├── grade-service/
├── task-service/
├── reminder-service/
├── docker/
│   ├── postgres/
│   └── mongodb/
├── docker-compose.yml
└── README.md

6. Testing Strategy
- Unit tests per service

- Integration tests using Testcontainers

- Containerized databases ensure reproducibility across environments

7. Future Enhancements
- Swagger/OpenAPI documentation

- OAuth2 / Keycloak security

- CI/CD pipeline

- Event-driven messaging