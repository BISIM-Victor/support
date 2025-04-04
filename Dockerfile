# Usa una imagen base con Tomcat y Java (puedes cambiar a openjdk:17-jdk si lo necesitas)
FROM tomcat:9.0-jdk17

# Elimina las aplicaciones por defecto de Tomcat (opcional pero recomendado)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia tu archivo .war al directorio webapps de Tomcat
COPY target/support.war /usr/local/tomcat/webapps/support.war

# Expone el puerto por defecto de Tomcat
EXPOSE 8080

# Inicia Tomcat
CMD ["catalina.sh", "run"]
