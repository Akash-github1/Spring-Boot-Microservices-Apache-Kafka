package com.order.external;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("DELIVERYAGENT")
public interface OrderDeliveryInterface {

	@PostMapping("/delivery/update")
	public ResponseEntity<Map<String, String>> updateLocation();
}
