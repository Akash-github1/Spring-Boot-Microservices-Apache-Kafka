# Step 1: Use the official OpenJDK base image
FROM openjdk:17-jdk-slim

# Step 2: Create a directory to hold the application
WORKDIR /app

# Step 3: Add the application JAR to the container
# Replace 'your-microservice.jar' with the actual name of your microservice's jar file
COPY target/your-microservice.jar /app/deliveryAgent.jar

# Step 4: Expose the port that your Spring Boot app runs on
# Update the port based on your microservice configuration (e.g., 8080)
EXPOSE 8080

# Step 5: Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/deliveryAgent.jar"]
