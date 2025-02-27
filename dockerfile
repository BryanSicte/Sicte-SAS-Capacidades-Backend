# Imagen base de OpenJDK
FROM eclipse-temurin:17-jdk

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el archivo JAR generado
COPY target/*.jar app.jar

# Definir el puerto (Render lo asigna dinámicamente)
ENV PORT=8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app.jar"]