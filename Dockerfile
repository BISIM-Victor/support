FROM tomcat:9-jdk8

# Elimina el archivo WAR de ejemplo
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Descarga el driver de PostgreSQL
RUN curl -o /usr/local/tomcat/lib/postgresql.jar https://jdbc.postgresql.org/download/postgresql-42.7.3.jar

# Copia tu archivo WAR a la carpeta de aplicaciones de Tomcat
COPY target/support.war /usr/local/tomcat/webapps/ROOT.war

# Expone el puerto en el que Tomcat escucha
EXPOSE 8080

# Arranca Tomcat
CMD ["catalina.sh", "run"]
