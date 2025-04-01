# Usa una imagen base de Tomcat
FROM tomcat:9-jdk8

# Elimina el archivo WAR de ejemplo de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT


# Copia tu archivo WAR a la carpeta de aplicaciones de Tomcat
COPY target/support.war /usr/local/tomcat/webapps/ROOT.war


# Expone el puerto en el que Tomcat escucha (por defecto 8080)
EXPOSE 8080

# Arranca Tomcat
CMD ["catalina.sh", "run"]

