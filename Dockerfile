FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
RUN ./mvnw install
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]