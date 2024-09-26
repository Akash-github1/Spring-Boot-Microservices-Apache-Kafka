package com.order.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDateTime;

@Entity
@Table(name = "Orders")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id", nullable = false, unique = true)
    private String orderId; // Use orderId as the primary key

    @Column(nullable = false)
    private String customerName; // Name of the customer

    @Column(nullable = false)
    private String status; // Order status (e.g., PENDING, CONFIRMED, CANCELED)

    @Column(nullable = false)
    private String restaurantId; // ID of the restaurant

    @Column(nullable = false)
    private double totalPrice; // Total price of the order
    
    @Column
    private String paymentId; // Associated orderId from the User entity

}
