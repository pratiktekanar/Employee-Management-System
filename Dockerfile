# ------------ Stage 1: Build the JAR using Maven ------------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# Copy your source code and build it
COPY . .
RUN mvn clean package -DskipTests

# ------------ Stage 2: Run the JAR ------------
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app

# Copy the built JAR from the build stage
COPY --from=build /app/target/*.jar app.jar

# Start the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]

EXPOSE 8080
