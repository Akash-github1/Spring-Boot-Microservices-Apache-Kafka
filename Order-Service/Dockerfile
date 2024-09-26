# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the Order-Service jar to the container
COPY target/Order-Service.jar /app/Order-Service.jar

# Expose the port on which this service runs
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "/app/Order-Service.jar"]
