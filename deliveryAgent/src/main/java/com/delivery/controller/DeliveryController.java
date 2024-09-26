package com.delivery.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.entities.PaymentDTO;
import com.delivery.service.DeliveryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

	@Autowired
	DeliveryService deliveryService;
	
    // Define latitude and longitude range for India
    private static final double INDIA_MIN_LAT = 8.0;
    private static final double INDIA_MAX_LAT = 37.0;
    private static final double INDIA_MIN_LON = 68.0;
    private static final double INDIA_MAX_LON = 97.0;

    // Method to generate random latitude and longitude within India's boundaries
    private double[] generateRandomCoordinates() {
        double latitude = INDIA_MIN_LAT + (Math.random() * (INDIA_MAX_LAT - INDIA_MIN_LAT));
        double longitude = INDIA_MIN_LON + (Math.random() * (INDIA_MAX_LON - INDIA_MIN_LON));
        return new double[]{latitude, longitude};
    }
	
    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> updateLocation() throws JsonMappingException, JsonProcessingException {
        // Generate the requested number of random coordinates within India

        for (int i = 0; i < 10; i++) {
            double[] coordinates = generateRandomCoordinates();
            double latitude = coordinates[0];
            double longitude = coordinates[1];

            deliveryService.updateLocation(latitude, longitude);

        }

        return new ResponseEntity<>(Map.of("meessage", "Location Produced..."), HttpStatus.OK);
    }
    
    @PostMapping("/payment")
    public ResponseEntity<Map<String, String>> paymentConfirmation(@RequestBody PaymentDTO paymentDTO) throws JsonMappingException, JsonProcessingException {

            deliveryService.paymentConfirmation(paymentDTO);

        return new ResponseEntity<>(Map.of("meessage", "Payment status updated Produced..."), HttpStatus.OK);
    }
	
	
//    @Scheduled(cron = "*/1 * * * * *")
//    public void updateLocationCron() throws JsonMappingException, JsonProcessingException {
//        double[] coordinates = generateRandomCoordinates();
//        double latitude = coordinates[0];
//        double longitude = coordinates[1];
//
//        deliveryService.updateLocation(latitude, longitude);
//
//    }
}
