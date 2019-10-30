# rest-api

Spring Boot REST API with two endpoints

GET /api/v1/users/

POST /api/v1/users/

Connection to the mysql database via a docker container:

docker run -it --rm mysql:5.7.15 mysql -h 192.168.99.100 -P 3306 -u root -p

CREATE DATABASE db_users



