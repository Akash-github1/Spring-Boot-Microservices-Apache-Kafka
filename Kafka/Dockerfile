# First stage: build environment
FROM apache/kafka:3.8.0 AS builder

# Set the working directory
WORKDIR /kafka

# Copy configuration files and start scripts into the image
COPY server.properties zookeeper.properties kafka-server-start.sh zookeeper-server-start.sh ./

# Ensure scripts are executable
RUN chmod +x kafka-server-start.sh zookeeper-server-start.sh

# Second stage: final image
FROM apache/kafka:3.8.0

# Set the working directory
WORKDIR /kafka

# Copy the executable scripts from the builder stage
COPY --from=builder /kafka/kafka-server-start.sh .
COPY --from=builder /kafka/zookeeper-server-start.sh .

# Copy the properties files
COPY server.properties zookeeper.properties ./

# Expose ports for Kafka and ZooKeeper
EXPOSE 9092
EXPOSE 2181

# Start ZooKeeper and Kafka when the container starts
CMD ["sh", "-c", "./zookeeper-server-start.sh zookeeper.properties & sleep 5; # Wait for ZooKeeper to start ./kafka-server-start.sh server.properties"]
