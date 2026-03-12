# Etapa 1: Construcción
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el pom.xml y descargamos las dependencias
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el código fuente y compilamos el proyecto
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos el .jar generado en la etapa anterior
COPY --from=build /app/target/examen1-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto que configuraste
EXPOSE 8081

# Comando para arrancar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]