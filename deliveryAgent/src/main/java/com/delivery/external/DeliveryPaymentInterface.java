package com.delivery.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.delivery.entities.PaymentDTO;

@FeignClient("PAYMENTSERVICE")
public interface DeliveryPaymentInterface {

    @PostMapping("/payment/process")
    public String processPayment(@RequestBody PaymentDTO paymentDTO);
}
