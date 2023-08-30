FROM openjdk:8
VOLUME /temp
COPY target/*.jar easycontrat-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","easycontrat-1.0-SNAPSHOT.jar"]
EXPOSE 8081