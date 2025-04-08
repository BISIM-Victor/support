# Usar una imagen base de OpenJDK 8
FROM openjdk:8-jre-alpine

# Copiar el archivo JAR de la aplicación al contenedor
COPY target/support-app.jar /app/support-app.jar

# Exponer el puerto que usará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando el contenedor inicie
ENTRYPOINT ["java", "-jar", "/app/mi-aplicacion.jar"]
