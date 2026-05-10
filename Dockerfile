FROM maven:3.9-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY anarobles-backend/pom.xml anarobles-backend/
RUN mvn -f anarobles-backend/pom.xml package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/anarobles-backend/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]