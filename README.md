# rest-api

Spring Boot REST API with two endpoints

GET /api/v1/users/

POST /api/v1/users/

Connection to the mysql database via a docker container

example:
docker run -it --rm mysql:5.7.15 mysql -h 192.168.99.100 -P 3306 -u root -p

CREATE DATABASE db_users



Database configuration in Springboot:  resources\application.properties


spring.jpa.hibernate.ddl-auto=update

spring.datasource.url=jdbc:mysql://192.168.99.100:3306/db_users

spring.datasource.username=root

spring.datasource.password=myPassword



