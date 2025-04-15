FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/support-0.0.1-SNAPSHOT.jar
COPY ./target/support-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
