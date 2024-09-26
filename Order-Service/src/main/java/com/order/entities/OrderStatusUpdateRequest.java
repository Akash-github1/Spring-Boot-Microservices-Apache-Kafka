package com.order.entities;

import lombok.Data;

@Data
public class OrderStatusUpdateRequest {
	private String status;
	private String paymentId;
}
