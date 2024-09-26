package com.endUser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.endUser.entities.OrderRequestDTO;
import com.endUser.external.UserOrderInterface;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserOrderInterface userOrderInterface;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/order")
    public String placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
    	System.out.println(orderRequestDTO);
        return userOrderInterface.placeOrder(orderRequestDTO);
    }

//    @GetMapping("/track/{orderId}")
//    public String trackOrder(@PathVariable String orderId) {
//        // Send tracking request to Kafka
////        kafkaTemplate.send("tracking-topic", orderId);
//        return userOrderInterface.placeOrder(orderRequestDTO);
//    }
}
