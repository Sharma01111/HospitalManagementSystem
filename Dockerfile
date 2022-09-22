FROM openjdk:17
ADD target/Hospital-Management-System-0.0.1-SNAPSHOT.jar Hospital-Management-System-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "/Hospital-Management-System-0.0.1-SNAPSHOT.jar"]