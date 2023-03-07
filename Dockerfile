FROM openjdk:17-jdk-slim
MAINTAINER Oleksy Fedorchenko
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]