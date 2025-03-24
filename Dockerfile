

# Usar una imagen base de OpenJDK 8 con Tomcat (ajustado para WAR)
FROM openjdk:8-jdk

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo WAR generado en target/
COPY target/support.war /app/app.war

# Exponer el puerto 8080 para la aplicación Spring Boot
EXPOSE 8080

# Ejecutar la aplicación Spring Boot WAR
CMD ["java", "-jar", "/app/app.war"]
