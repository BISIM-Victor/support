# Usa una imagen base con Java 8
FROM openjdk:8-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia tu JAR generado
COPY ./target/support-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponer el puerto que usa Spring Boot (Railway lo reasigna con $PORT)
EXPOSE 8080

# Variable de entorno que Railway utiliza para asignar el puerto
ENV PORT=8080

# Comando para ejecutar tu app
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
