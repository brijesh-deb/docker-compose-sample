FROM openjdk:8
ADD target/springboot-docker-compose-demo.jar springboot-docker-compose-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "springboot-docker-compose-demo.jar"]