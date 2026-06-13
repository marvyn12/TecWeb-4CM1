# Etapa 1: Construcción con Maven
FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución con Java 17 (Usando la imagen moderna)
FROM eclipse-temurin:17-jdk-alpine
# Copiamos el jar generado
COPY --from=build /target/*.jar app.jar
# Exponemos el puerto 8081
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]