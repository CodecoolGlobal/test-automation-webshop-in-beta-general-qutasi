# Base image with Maven and JDK
FROM maven:3.9.5-eclipse-temurin-17

# Set working directory
WORKDIR /app

# Copy the project files into the container
COPY . .

# Run Maven dependency resolution to cache dependencies
RUN mvn dependency:resolve

# Command to run tests (overridden in workflow)
CMD ["mvn", "test"]