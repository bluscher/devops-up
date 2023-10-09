
FROM maven:3.9.4-eclipse-temurin-17 AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
RUN mkdir /app
COPY --from=build /project/target/devops-0.0.1-SNAPSHOT.jar /app/devops-0.0.1-SNAPSHOT.jar
WORKDIR /app
CMD ["java", "-jar", "devops-0.0.1-SNAPSHOT.jar"]