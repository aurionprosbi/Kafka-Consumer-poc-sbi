package com.aurionpro.interceptors;

import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

public class KafkaConsumerInterceptors implements  ConsumerInterceptor<String, String> {

	@Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> records) {
        records.forEach(record -> {
        	
        	System.out.println("Key " +record.key());
            
        });
        return records;
    }

	
	@Override
	public void configure(Map<String, ?> arg0) {
		// TODO Auto-generated method stub
		System.out.println("============="+arg0);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
		
		System.out.println("==================================== " +map);
		
		
		// TODO Auto-generated method stub
		
	}

 

}
