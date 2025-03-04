FROM maven:3.9.9-eclipse-temurin-23-alpine AS build

COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-alpine-3.21
COPY target/Vircade-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java" , "-jar" , "/app.jar"]

