package com.delivery.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.delivery.entities.PaymentDTO;
import com.delivery.external.DeliveryPaymentInterface;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DeliveryService {
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	@Autowired
	DeliveryPaymentInterface deliveryPaymentInterface;

    private static final String OPENCAGE_API_URL = "https://api.opencagedata.com/geocode/v1/json?q=%s,%s&key=%s";
    private static final String API_KEY = "f0180ae2d86a466b89538b93e60c9c26";
	
	public boolean updateLocation(double latitude, double longitude) throws JsonMappingException, JsonProcessingException {
		
        String url = String.format(OPENCAGE_API_URL, latitude, longitude, API_KEY);

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);
        
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode results = objectMapper.readTree(response).path("results");
        JsonNode firstResult = results.get(0);
        String formattedAddress = firstResult.path("formatted").asText();
        
        Map<String, Object> deliveryLocation = new HashMap<>();
        deliveryLocation.put("latitude", latitude);
        deliveryLocation.put("longitude", longitude);
        deliveryLocation.put("formattedAddress", formattedAddress);
        
        String jsonString = objectMapper.writeValueAsString(deliveryLocation);
    
		kafkaTemplate.send("location-update-topic", jsonString);
		
		return true;
	}
	
	public boolean paymentConfirmation(PaymentDTO paymentDTO) throws JsonMappingException, JsonProcessingException {
		
		deliveryPaymentInterface.processPayment(paymentDTO);
		
//		kafkaTemplate.send("order-topic", paymentDTO.toString());
		
		return true;
	}

}
