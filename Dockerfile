
# Usa Amazon Corretto con Java 17
FROM amazoncorretto:17

# Crea el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR a la imagen
COPY target/support.jar app.jar

# Expone el puerto 8080
EXPOSE 8080

# Arranca la aplicación Spring Boot
CMD ["java", "-jar", "app.jar", "--server.port=8080"]
