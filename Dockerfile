FROM openjdk:11
MAINTAINER aksoymuratkaya@gmail.com
COPY target/UserManagement-0.0.1-SNAPSHOT.jar UserManagement-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/UserManagement-0.0.1-SNAPSHOT.jar"]