package com.endUser.configuration;

import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class KafkaListenerConfig {
	
	@KafkaListener(topics = "location-update-topic", groupId = "group-1")
	public void updateLocation(String value) throws JsonMappingException, JsonProcessingException {
		
        // Convert the JSON string to a Map
		ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> deliveryLocation = objectMapper.readValue(value, Map.class);

        // Extracting values from the map
        Double latitude = (Double) deliveryLocation.get("latitude");
        Double longitude = (Double) deliveryLocation.get("longitude");
        String formattedAddress = (String) deliveryLocation.get("formattedAddress");

        // Process the delivery location
//        System.out.printf("Your food at location: Latitude: %.6f, Longitude: %.6f, Address: %s%n", latitude, longitude, formattedAddress);
        
        System.out.printf("Agent Location : %s%n",formattedAddress);

		
	}
	
    @KafkaListener(topics = "order-topic", groupId = "group-1")
    public void listenOrder(String message) {
        System.out.println(message);
        // Parse and handle order confirmation
    }
    
//    @KafkaListener(topics = "order-confirm-topic", groupId = "group-1")
//    public void listenConfirmOrder(String message) {
//        System.out.println(message);
//        // Parse and handle order confirmation
//    }

}
