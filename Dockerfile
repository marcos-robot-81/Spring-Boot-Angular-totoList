FROM openjdk:17-jdk-alpine

WORKDIR /app

# Copia todo o código fonte do seu projeto para o contêiner
COPY ToList /app

# Define a entrada para a execução
CMD ["./mvnw", "spring-boot:run"]