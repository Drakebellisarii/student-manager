# Student Roster Manager Microservice

This project is a rudimentary RESTful microservice for managing a student roster. The application is built using Java with the Spring Boot framework, and it is packaged in a Docker container. The service allows users to interact with student data (year, major, names, etc.) through four REST commands: GET, POST, PUT, and DELETE. Swagger is enabled for API documentation.

## Learning Journey and Decisions

For this project, I chose to use Java with Spring Boot due to its robustness and extensive ecosystem. I enabled Swagger for API documentation to facilitate interaction with the microservice. Below are the main sources that guided my solution:

- [Spring Boot QuickStart guides](https://spring.io/guides)
- [Enable OpenAPI 3 (Swagger) in Spring Boot 3](https://www.baeldung.com/spring-boot-swagger-3)
- [Dockerizing a Spring Boot application](https://spring.io/guides/topicals/spring-boot-docker/)

## Prerequisites

Before you begin, ensure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Docker](https://www.docker.com/get-started)
- [Git](https://git-scm.com/)

## Building and Running the Application
### Clone the repository 
  1. Clone the repository: git clone https://github.com/username/reponame.git
### Build the Docker Image
  2. Build the Docker image: docker build -t student-roster-manager .
### Running the Docker Container
  3. Run the docker container: docker run -p 8080:8080 student-roster-manager
### Accesing the application
  4. The application will be running at http://localhost:8080. You can access the Swagger API documentation at http://localhost:8080/swagger-ui.html.
## Project Structure
```plaintext
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── studentroster
│   │   │               ├── StudentRosterApplication.java
│   │   │               ├── controller
│   │   │               │   └── StudentController.java
│   │   │               ├── model
│   │   │               │   └── Student.java
│   │   │               └── repository
│   │   │                   └── StudentRepository.java
│   │   └── resources
│   │       └── application.properties
├── Dockerfile
├── pom.xml
└── README.md


