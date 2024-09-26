package com.endUser.external;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.endUser.entities.OrderRequestDTO;

@FeignClient("deliveryAgent")
public interface UserDeliveryInterface {

    @PostMapping("/update")
    public ResponseEntity<Map<String, String>> updateLocation();
}
