package com.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.payment.entities.OrderStatusUpdateRequest;
import com.payment.entities.PaymentConfirmationEntity;
import com.payment.entities.PaymentDTO;
import com.payment.external.PaymentOrderInterface;
import com.payment.repository.PaymentRepository;

@Service
public class PaymentServiceImpl {
	
	@Autowired
	PaymentRepository paymentRepository;
	
	@Autowired
	PaymentOrderInterface paymentOrderInterface;
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	

	public void processPayment(PaymentDTO paymentDTO) {
		
		PaymentConfirmationEntity payment = new PaymentConfirmationEntity();
		
		payment.setOrderId(paymentDTO.getOrderId());
		payment.setPaymentStatus(paymentDTO.getPaymentStatus());
		payment.setAmountPaid(paymentDTO.getAmountPaid());
		payment.setPaymentMethod(paymentDTO.getPaymentMethod());
		payment.setPaymentDate(paymentDTO.getPaymentDate());
		
		PaymentConfirmationEntity newPayment = paymentRepository.save(payment);
		
		OrderStatusUpdateRequest osr = new OrderStatusUpdateRequest();
		osr.setStatus("Delivered");
		osr.setPaymentId(newPayment.getId());
		
		paymentOrderInterface.updateOrderStatus(newPayment.getOrderId(), osr);
		
		kafkaTemplate.send("order-topic", "Order Delivered...");
		
		
		
	}

}
