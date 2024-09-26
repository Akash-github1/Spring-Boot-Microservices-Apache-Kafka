package com.delivery.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDTO {

    @JsonProperty("payment_id")
    private String id; // Payment ID (primary key)

    @JsonProperty("order_id")
    private String orderId; // Associated orderId from the User entity

    @JsonProperty("payment_status")
    private String paymentStatus; // Status of payment (e.g., SUCCESS, FAILED, PENDING)

    @JsonProperty("amount_paid")
    private double amountPaid; // Amount paid for the order

    @JsonProperty("payment_method")
    private String paymentMethod; // Method of payment (e.g., Credit Card, UPI, Cash)

    @JsonProperty("payment_date")
    private Date paymentDate; // Date and time of payment
}
