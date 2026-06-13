# Usar una imagen de Java 21 con Maven incluido para compilar
FROM maven:3.9.6-eclipse-temurin-21

# Crear una carpeta de trabajo dentro del servidor de Render
WORKDIR /app

# Copiar los archivos de tu proyecto (pom.xml, src, etc.) al servidor
COPY . .

# Compilar el proyecto y generar el archivo .jar
RUN mvn clean package -DskipTests

# Indicar el puerto que usa Spring Boot por defecto
EXPOSE 8080

# Comando para arrancar tu aplicación usando el nombre de tu archivo .jar
CMD ["java", "-jar", "target/links-0.0.1-SNAPSHOT.jar"]
