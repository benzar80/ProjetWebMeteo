# Build stage
FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install

# Package stage
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/meteo-0.0.1-SNAPSHOT.jar demo.jar
EXPOSE 443
ENTRYPOINT ["java", "-jar", "demo.jar"]
