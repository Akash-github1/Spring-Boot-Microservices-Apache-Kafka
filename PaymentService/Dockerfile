# Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the PaymentService jar to the container
COPY target/PaymentService.jar /app/PaymentService.jar

# Expose the port on which this service runs
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "/app/PaymentService.jar"]
