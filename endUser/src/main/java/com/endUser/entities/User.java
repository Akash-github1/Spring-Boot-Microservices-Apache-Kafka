package com.endUser.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "Users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(nullable = false, unique = true)
    private String orderId; // Use orderId as the primary key

    @Column(nullable = false)
    private String customerName; // Name of the customer

    @Column(nullable = false)
    private String status; // Order status (e.g., PENDING, CONFIRMED, CANCELED)

    @Column(nullable = false)
    private String restaurantId; // ID of the restaurant

    @Column(nullable = false)
    private double totalPrice; // Total price of the order

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date orderDate; // Order creation date

}
