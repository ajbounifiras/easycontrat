FROM openjdk:8
VOLUME /temp
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","easycontrat-1.0-SNAPSHOT.jar"]
EXPOSE 8081