FROM maven:3.9.9-eclipse-temurin-23-alpine AS build

COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:23-alpine-3.21
COPY --from=build /target/*.jar Vircade.jar
EXPOSE 8080
ENTRYPOINT ["java" , "-jar" , "/app.jar"]

