# Usa una imagen base de Tomcat
FROM tomcat:9-jdk8

# Elimina el archivo WAR de ejemplo de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copia tu archivo WAR a la carpeta de aplicaciones de Tomcat
COPY target/support/WEB-INF/lib/postgresql-42.7.3.jar /usr/local/tomcat/lib/

# Expone el puerto en el que Tomcat escucha (por defecto 8080)
EXPOSE 8080

# Arranca Tomcat
CMD ["catalina.sh", "run"]

