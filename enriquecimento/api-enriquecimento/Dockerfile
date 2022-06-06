FROM openjdk:11-jre-slim

WORKDIR /app

# define uma variavel que pode ser fornecida em tempo de build
ARG JAR_FILE

# copia da pasta target o arquivo jar. Qual arquivo jar? Qual o nome do arquivo?
# Esse que foi informado na variavel JAR_FILE em tempo de build
# O maven informou esse nome quando rodou o build.
# Através do ${project.build.finalName} lá no pom.xml ele pega o nome do arquivo jar
COPY target/${JAR_FILE} /app/app.jar

COPY wait-for-it.sh /wait-for-it.sh

#tornar o arquivo wait-for-it.sh disponível como um executável, mas não executamos ele dentro do CMD
RUN chmod +x /wait-for-it.sh

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]