package com.delivery.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Kafkaconfig {
	
	public NewTopic newTopic() {
		
		return TopicBuilder.name("location-update-topic").build();
	}

}
