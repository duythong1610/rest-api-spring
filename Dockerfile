
FROM openjdk:11-jdk-slim
ADD target/crud.jar crud.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","crud.jar"]