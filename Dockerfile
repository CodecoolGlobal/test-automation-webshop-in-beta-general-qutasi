FROM maven:latest AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src/ src/
RUN mvn clean install -DskipTests

FROM maven:latest
WORKDIR /app
COPY --from=builder /app/target /app/target
CMD ["mvn", "test"]