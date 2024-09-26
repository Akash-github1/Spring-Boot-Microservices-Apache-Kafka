package com.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.payment.entities.PaymentConfirmationEntity;
import com.payment.entities.PaymentDTO;
import com.payment.repository.PaymentRepository;
import com.payment.service.PaymentServiceImpl;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentServiceImpl paymentServiceImpl;
	
	
    @PostMapping("/process")
    public ResponseEntity<String> processPayment(@RequestBody PaymentDTO paymentDTO) {
    	
    	paymentServiceImpl.processPayment(paymentDTO);
        return ResponseEntity.ok("Payment processed successfully.");
    }

}
