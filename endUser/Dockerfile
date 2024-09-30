# Step 1: Use a Maven image to build the application
FROM maven:3.8.5-openjdk-17 AS build

# Step 2: Set working directory in the build stage
WORKDIR /app

# Step 3: Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Step 4: Build the application to generate the JAR file
RUN mvn clean package -DskipTests

# Step 5: Use a minimal base image with JDK to run the JAR
FROM openjdk:17-jdk-slim

# Step 6: Set working directory for the runtime
WORKDIR /app

# Step 7: Copy the JAR file from the build stage
COPY --from=build /app/target/endUser.jar /app/endUser.jar

# Step 8: Expose the application port (usually 8080 for Spring Boot apps)
EXPOSE 8083

# Step 9: Run the application
ENTRYPOINT ["java", "-jar", "/app/endUser.jar"]