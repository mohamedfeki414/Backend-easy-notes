FROM openjdk:17
COPY ./target/easy-notes-0.0.1-SNAPSHOT.jar easy-notes-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "easy-notes-0.0.1-SNAPSHOT.jar"]