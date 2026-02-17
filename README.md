# Task Management Application

A full-stack Task Management app built with **Spring Boot (Java 21)** and **React + TypeScript**. It supports creating, updating, deleting, and managing tasks with pagination and validation.

---

## Tech Stack

**Backend:** Spring Boot 3.x, JPA (Hibernate), H2/PostgreSQL, Lombok, Swagger, JUnit  
**Frontend:** React + TypeScript (Vite), React Router, Axios, React Query, Playwright

---

## Project Structure
task-management-app/
├── backend/
└── frontend/
---

## Prerequisites

- Java 21+
- Maven 3.9+
- Node.js 18+
- npm/yarn
- Git

---

## Run Backend

```bash
cd backend
mvn spring-boot:run
Backend: http://localhost:8080
Swagger: http://localhost:8080/swagger-ui.html
cd frontend
npm install
npm run dev
Tests
cd backend && mvn test
Frontend
cd frontend && npm test
npx playwright test

Author: Nilesh Jadhav
Purpose: Assessment / Demo project
