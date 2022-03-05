FROM openjdk:11-jre-slim

WORKDIR /app

ARG JAR_FILE

COPY target/${JAR_FILE} /app/app.jar

EXPOSE 8081

CMD ["java", "-jar", "app.jar"]