FROM openjdk:8-jdk-alpine
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar", "--server.port=8082"]