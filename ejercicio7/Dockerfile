# ==========================================
# Etapa 1: Construcción (Build)
# Usamos una imagen con Maven y Java 17 para compilar tu código
# ==========================================
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos el pom.xml y descargamos dependencias (esto hace que el build sea más rápido si no cambias el pom)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copiamos el resto del código (src)
COPY src ./src

# Compilamos el proyecto saltándonos las pruebas para ahorrar tiempo
RUN mvn clean package -DskipTests

# ==========================================
# Etapa 2: Ejecución (Run)
# Usamos una imagen de Java 17 súper ligera (Alpine) solo para correr la app
# ==========================================
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Copiamos el archivo .jar que se generó en la etapa 1
COPY --from=build /app/target/*.jar app.jar

# Exponemos el puerto (Render ignora esto y asigna el suyo, pero es buena práctica)
EXPOSE 8080

# Comando para arrancar tu servidor Spring Boot
ENTRYPOINT ["java", "-jar", "app.jar"]