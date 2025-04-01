# Usando Tomcat base image
FROM tomcat:9-jdk8

# Eliminar la aplicación predeterminada (ROOT)
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copiar el archivo WAR a la carpeta webapps de Tomcat
COPY target/support.war /usr/local/tomcat/webapps/ROOT.war
COPY target/lib/postgresql-42.7.3.jar /usr/local/tomcat/webapps/ROOT/WEB-INF/lib/
# Copiar el JAR de PostgreSQL a la carpeta lib de Tomcat (si no está incluido en el WAR)
COPY target/WEB-INF/lib/postgresql-42.7.3.jar /usr/local/tomcat/webapps/ROOT/WEB-INF/lib/
COPY target/support/WEB-INF/lib/postgresql-42.7.3.jar /usr/local/tomcat/webapps/ROOT/WEB-INF/lib/


# Exponer el puerto
EXPOSE 8080
