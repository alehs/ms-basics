package org.as.avro;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.as.avro.domain.Message;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

import static io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG;

public class KafkaMessageProducer {

	public static final String AVRO_MESSAGES_TOPIC = "avro_messages";

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello world!");

		Properties props = new Properties();

		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092, http://localhost:29092");
		props.put(SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:18081");

		props.put(ProducerConfig.RETRIES_CONFIG, 0);
		props.put(ProducerConfig.ACKS_CONFIG, "all");
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);

		KafkaProducer<String, Message> kafkaProducer = new KafkaProducer<>(props);

		for (var i = 0; i < 10; i++) {
			Message message = new Message(i, LocalTime.now().toNanoOfDay(), "Hello world!");
			ProducerRecord<String, Message> producerRecord = new ProducerRecord<>(AVRO_MESSAGES_TOPIC, message);
			kafkaProducer.send(producerRecord, new Callback() {
				@Override
				public void onCompletion(RecordMetadata recordMetadata, Exception e) {
					if (e == null) {
						System.out.println("message sent. metadata:" + recordMetadata.toString());
					} else {
						e.printStackTrace();
					}
				}
			});
			Thread.currentThread().sleep(1000);
		}

		kafkaProducer.flush();
		kafkaProducer.close(Duration.ofMinutes(1));
	}

}
