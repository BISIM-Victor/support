# Usar una imagen base de OpenJDK 8 con Tomcat
FROM openjdk:8-jdk

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el WAR generado en target/
COPY target/support.war /app/app.war

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/app.war"]
