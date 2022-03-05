FROM openjdk:11-jre-slim

WORKDIR /app

ARG JAR_FILE

COPY target/${JAR_FILE} /app/app.jar
COPY wait-for-it.sh /wait-for-it.sh

# tornar o arquivo wait-for-it.sh como executavel
RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]