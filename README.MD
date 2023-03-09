1.Maven clean install. 
It makes .jar file in target folder.
2.We have a Dockerfile and docker-compose.yml.
3.To build our container with Spring Boot, Apache Kafka and MongoDB
we need to type in terminal command "docker-compose build".
4.To run our container we need to type in terminal
command "docker-compose up".
Then we can access to our Spring Boot and can POST with address
http://localhost:8080/mailprops with JSON body:

{
"subject":"subject",
"content":"Hello Test",
"email":"otihiy@gmail.com"
}