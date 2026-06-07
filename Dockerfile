# Etapa 1: Construcción con Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

# Etapa 2: Ejecución con Java 21 (Ligero)
FROM eclipse-temurin:21-jre-alpine
# Copiamos el jar generado de la etapa anterior
COPY --from=build /home/app/target/*.jar app.jar
# Exponemos el puerto que configuraste en application.properties
EXPOSE 8081
ENTRYPOINT ["java","-jar","/app.jar"]