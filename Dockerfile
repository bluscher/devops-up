FROM openjdk:17-jdk-alpine

COPY target/devops 0.0.1-SNAPSHOT.jar appTpDevopsUP-1.0.0.jar

ENTRYPOINT [ "java", "-jar", "app-1.0.0.jar" ]