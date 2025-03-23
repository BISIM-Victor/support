# Usar una imagen base de OpenJDK 8 con Tomcat
FROM openjdk:8-jdk

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Definir las variables de entorno para la conexión a MySQL
ENV MYSQL_HOST=mysql-5-7-x3ew.onrender.com
ENV MYSQL_PORT=3306
ENV MYSQL_DATABASE=support
ENV MYSQL_USER=user
ENV MYSQL_PASSWORD=123456

# Copiar el WAR generado en target/
COPY target/support.war /app/app.war

# Exponer el puerto en el que corre la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/app.war"]
