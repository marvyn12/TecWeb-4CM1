# Etapa 1: Construcción (Descarga dependencias y compila el proyecto)
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
# Copiamos el pom.xml y el código fuente
COPY pom.xml .
COPY src ./src
# Compilamos el proyecto ignorando las pruebas para que sea más rápido
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Crea la imagen final súper ligera)
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
# Copiamos el archivo .jar que se generó en la Etapa 1
COPY --from=build /app/target/Practica1-0.0.1-SNAPSHOT.jar app.jar
# Exponemos el puerto estándar de Spring Boot
EXPOSE 8080
# Comando para arrancar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]