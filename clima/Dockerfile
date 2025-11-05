FROM maven:3.9.11-amazoncorretto-17 AS build
WORKDIR /app
COPY .. .
RUN mvn clean package -DskipTests

FROM amazoncorretto:17
WORKDIR /app
COPY --from=build ./app/clima/target/*.jar ./app.jar

ENTRYPOINT exec java -jar -Dspring.profiles.active=production app.jar