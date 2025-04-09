# Etapa 1: Construcción del WAR con Maven y JDK 21
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con OpenJDK 21 y Python 3
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Instalar Python
RUN apt-get update && apt-get install -y python3 python3-pip python3-venv
RUN pip3 install --break-system-packages PyPDF2 pandas

COPY --from=build /app/target/*.war app.war
COPY scripts/Leer_PDF.py /app/scripts/Leer_PDF.py
CMD ["java", "-Xms512m", "-Xmx1536m", "-jar", "app.war"]