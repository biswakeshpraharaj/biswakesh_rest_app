biswakesh_rest_app
This is a sample of a Spring Boot dockerized app. In order to run it, perform the following commands:
cd rest-service/
mvn package -DskipTests 
sudo docker build -t spring-boot:1.0 .

sudo docker run -d -p 8080:8080 -t spring-boot:1.0

Check if it is working by hitting the swagger endpoint and hitting the book CRUD APIS:

http://localhost:8080/swagger-ui.html
