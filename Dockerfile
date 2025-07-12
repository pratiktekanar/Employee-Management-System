# Use Java 21 base image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy your Spring Boot JAR to the container
COPY target/product-0.0.1-SNAPSHOT.jar app.jar

# Set the startup command
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose port 8080 (default for Spring Boot)
EXPOSE 8080
