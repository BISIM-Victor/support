FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/support-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
