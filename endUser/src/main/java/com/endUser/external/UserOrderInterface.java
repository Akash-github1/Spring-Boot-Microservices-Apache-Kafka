package com.endUser.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.endUser.entities.OrderRequestDTO;

@FeignClient("ORDER-SERVICE")
public interface UserOrderInterface {

    @PostMapping("/order/place")
    String placeOrder(@RequestBody OrderRequestDTO orderRequest);
}
