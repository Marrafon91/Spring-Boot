# ====== BUILD STAGE ======
FROM maven:3.8.8-amazoncorretto-21-al2023 AS build
WORKDIR /build

COPY . .

RUN mvn clean package -DskipTests


# ====== RUNTIME STAGE ======
FROM amazoncorretto:21.0.5 AS runtime
WORKDIR /app

COPY --from=build /build/target/*.jar /app/libraryapi.jar

EXPOSE 8080
EXPOSE 9090

# ✅ Evite deixar segredos dentro da imagem
# (Defina essas variáveis externamente com `docker run -e` ou `--env-file`)
ENV SPRING_PROFILES_ACTIVE=production
ENV TZ=America/Sao_Paulo

# ✅ Forma JSON recomendada para o ENTRYPOINT
ENTRYPOINT ["java", "-jar", "libraryapi.jar"]

# LABEL (mantido)
LABEL authors="Guilherme Marrafon"
