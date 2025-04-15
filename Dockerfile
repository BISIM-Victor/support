FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY ./target/support-0.0.1-SNAPSHOT.jar /app/app.jar
RUN ls -l /app
CMD ["java", "-jar", "/app/app.jar"]
