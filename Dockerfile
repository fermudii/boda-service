# Etapa 1: Build del proyecto
FROM gradle:8.1.1-jdk17 AS build

# Crea un directorio de trabajo
WORKDIR /app

# Copiar los gradle wrapper y config primero
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Descarga las dependencias para que se cacheen
RUN gradle build --no-daemon || true

# Copia todo el código fuente
COPY . .

# Compila y empaqueta el proyecto
RUN ./gradlew build --no-daemon

# Etapa 2: Imagen final ligera con JDK
FROM eclipse-temurin:17-jre

# Crea directorio para la aplicación
WORKDIR /app

# Copia el jar generado desde la etapa de build
COPY --from=build /app/build/libs/*.jar app.jar

# Expone el puerto (Render suele leer del PORT env var, pero es buena práctica)
EXPOSE 8080

# Comando para correr la app
ENTRYPOINT ["java", "-jar", "app.jar"]
