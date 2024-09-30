# Use the official Apache Kafka image
FROM apache/kafka:3.8.0

# Set the working directory
WORKDIR /kafka

# Copy configuration files and start scripts into the image
COPY server.properties zookeeper.properties kafka-server-start.sh zookeeper-server-start.sh ./

# Set executable permissions for the start scripts
RUN chmod +x kafka-server-start.sh zookeeper-server-start.sh

# Expose ports for Kafka and ZooKeeper
EXPOSE 9092
EXPOSE 2181

# Start ZooKeeper and Kafka when the container starts
CMD ["sh", "-c", "./zookeeper-server-start.sh zookeeper.properties & sleep 5 && /kafka-server-start.sh server.properties"]
