package com.aurionpro.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import com.aurionpro.interceptors.KafkaConsumerInterceptors;


@Configuration
@EnableKafka
public class KafkaConfig {

	@Bean
	public Map<String, Object> consumerConfig() {

		Map<String, Object> map = new HashMap<>();

		map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
				"cms-cluster-kafka-plain-bootstrap-icashpro-sbi.apps.cmp-icashpro.asl.mum.sst:443");
		map.put(ConsumerConfig.GROUP_ID_CONFIG, "auro");
		map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
		map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		map.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, KafkaConsumerInterceptors.class.getName());
		map.put(org.springframework.kafka.support.serializer.JsonDeserializer.TRUSTED_PACKAGES, "com.aurionpro");

		// SSL Configuration
		map.put("security.protocol", "SSL");
		map.put("ssl.truststore.location",
				"C:\\Users\\abhishek.talakeri\\Documents\\kafka\\Kafka-Consumer2\\sbi.jks");
		map.put("ssl.truststore.password", "aurionpro");

		return map;
	}

	@Bean
	public ConsumerFactory<String, String> consumerFactory() {

		return new DefaultKafkaConsumerFactory<>(consumerConfig());

	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
