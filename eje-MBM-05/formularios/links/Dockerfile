
# Usar una imagen de Java 21 con Maven incluido
FROM maven:3.9.6-eclipse-temurin-21

# Crear una carpeta de trabajo dentro del servidor
WORKDIR /app

# Copiar todos tus archivos
COPY . .

# Compilar el proyecto (esto evita usar el archivo mvnw que nos daba error)
RUN mvn clean package -DskipTests

# Exponer el puerto
EXPOSE 8080

# Arrancar la pagina
CMD ["java", "-jar", "target/links-0.0.1-SNAPSHOT.jar"]
