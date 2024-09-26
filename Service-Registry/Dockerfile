# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Service-Registry jar to the container
COPY target/Service-Registry.jar /app/Service-Registry.jar

# Expose the port on which Eureka is running (usually 8761)
EXPOSE 8761

# Run the application
ENTRYPOINT ["java", "-jar", "/app/Service-Registry.jar"]
