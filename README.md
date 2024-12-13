# Simple Backend Application

This is a simple Spring Boot backend application using **H2 Database** and a **REST API**. It demonstrates how to set up a basic Spring Boot project with an embedded H2 database and how to expose data via RESTful endpoints.

## Features

- **Spring Boot** for creating the backend application
- **H2 Database** for the in-memory database
- **REST API** for handling HTTP requests

- **Spring Data JPA** for database interaction

## Prerequisites

- Java 17 or higher
- Maven

## Setup

### 1. Clone the repository

```bash
git clone https://github.com/Khushi-Saraswat/simple-backend-application.git
cd simple-backend-application


# application.properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console


Dependencies
The application uses the following Maven dependencies:

Spring Boot (Web, Security, Data JPA)
H2 Database (for in-memory database)
Lombok (to reduce boilerplate code)

