# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the endUser service jar to the container
COPY target/endUser.jar /app/endUser.jar

# Expose the port on which this service runs
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "/app/endUser.jar"]
