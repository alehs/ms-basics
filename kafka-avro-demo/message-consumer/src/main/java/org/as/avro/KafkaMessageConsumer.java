package org.as.avro;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.as.avro.domain.Message;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;

public class KafkaMessageConsumer {
	public static final String AVRO_MESSAGES_TOPIC = "avro_messages";

	public static void main(String[] args) {

		Properties props = new Properties();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092, http://localhost:29092");
		props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:18081");

		props.put(ConsumerConfig.GROUP_ID_CONFIG, "avro-message-consumers");
		props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);

		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);

		KafkaConsumer<String, Message> kafkaConsumer = new KafkaConsumer<>(props);
		kafkaConsumer.subscribe(Arrays.asList(AVRO_MESSAGES_TOPIC));

		while(true){
			ConsumerRecords<String, Message> records =
					kafkaConsumer.poll(Duration.ofMillis(100));

			for (ConsumerRecord<String, Message> record : records){
				System.out.println("Key: " + record.key() + ", Value: " + record.value());
				System.out.println("Partition: " + record.partition() + ", Offset:" + record.offset());
			}
		}

	}
}
