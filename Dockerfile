FROM openjdk:8-jdk-alpine
# VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} gittest.jar
ENTRYPOINT ["java","-jar","/gittest.jar"]