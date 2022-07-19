FROM openjdk:8-jdk-alpine
# VOLUME /tmp
EXPOSE 8088
ENV TZ=Asia/Taipei
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /mnt/gittest.jar
WORKDIR /mnt
ENTRYPOINT ["java","-jar","/mnt/gittest.jar"]