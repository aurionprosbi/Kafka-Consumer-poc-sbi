package com.aurionpro.kafkaListneres;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CustomKafkaListners {

	Logger log = LoggerFactory.getLogger(CustomKafkaListners.class);

	@KafkaListener(topics = "my-topic", groupId = "auro")
	public void consume1(String msg) {
		log.info("Consumer 1 Recevied Message " + msg);
	}

	@KafkaListener(topics = "my-topic", groupId = "auro")
	public void consume2(String msg) {
		log.info("Consumer 2 Recevied Message " + msg);
	}

	@KafkaListener(topics = "my-topic", groupId = "auro")
	public void consume3(String msg) {
		log.info("Consumer 3 Recevied Message " + msg);
	}
}
