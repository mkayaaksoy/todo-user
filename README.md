# First Run

1. Maven has to be already installed on system.
2. Java 11 has to be already installed on system.
3. application.properties has spring.datasource.url, it can changeable.
4. Check postgresql server runs. Database has to be created.
5. `mvn clean spring-boot:run` command run.

# Tests Run

`mvn clean test` command run.


# Create&Run Docker Image
`mvn clean package` exported jar file.

`docker build -f Dockerfile -t user-server:latest .` creating docker image

`docker run user-server:latest` running image.

#Swagger
After application started `http://localhost:8081/swagger-ui/index.html#/`


Spring boot helps [click.](HELP.md)
