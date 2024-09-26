package com.order.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequestDTO {

    @JsonProperty("order_id")
    private String orderId; // Use orderId as the primary key

    @JsonProperty("customer_name")
    private String customerName; // Name of the customer

    @JsonProperty("status")
    private String status; // Order status (e.g., PENDING, CONFIRMED, CANCELED)

    @JsonProperty("restaurant_id")
    private String restaurantId; // ID of the restaurant

    @JsonProperty("total_price")
    private double totalPrice; // Total price of the order
}
