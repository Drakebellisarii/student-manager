FROM eclipse-temurin:21-alpine
COPY target/spring-boot-swagger-3-example-0.0.1-SNAPSHOT.jar app.jar
LABEL authors="drake"
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]