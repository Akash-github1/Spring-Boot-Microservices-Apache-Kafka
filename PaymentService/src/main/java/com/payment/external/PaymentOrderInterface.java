package com.payment.external;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.payment.entities.OrderStatusUpdateRequest;


@FeignClient("ORDER-SERVICE")
public interface PaymentOrderInterface {

    @PutMapping("/order/update-status/{orderId}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable String orderId, @RequestBody OrderStatusUpdateRequest statusUpdateRequest);
    
}
