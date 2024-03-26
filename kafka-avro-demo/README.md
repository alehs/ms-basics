# Kafka Producer and Consumer with Avro serializer

# Set up Kafka and Zookeeper

I'm using Docker to run Kafka and Zookeeper. You can use the following commands to run them:

```docker compose up -d```

# Create a topic

```docker exec -it kafka /opt/bitnami/kafka/bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic avro_messages```

# Compile and run the Consumer

```mvn clean compile exec:java -Dexec.mainClass="com.example.kafka.consumer.Consumer"```

# Compile and run the Producer

```mvn clean compile exec:java -Dexec.mainClass="com.example.kafka.producer.Producer"```


see screenshots with results running on local env:
 - kafka-topic.png
 - kafka-ui-schema-registry.png
