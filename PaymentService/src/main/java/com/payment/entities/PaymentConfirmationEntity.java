package com.payment.entities;


import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Payments")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentConfirmationEntity {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate the ID
    @Column(name = "payment_id", nullable = false, unique = true)
    private String id; // Payment ID (primary key)

    @Column(name = "order_id", nullable = false)
    private String orderId; // Associated orderId from the User entity

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus; // Status of payment (e.g., SUCCESS, FAILED, PENDING)

    @Column(name = "amount_paid", nullable = false)
    private double amountPaid; // Amount paid for the order

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod; // Method of payment (e.g., Credit Card, UPI, Cash)

    @Temporal(TemporalType.DATE)
    @Column(name = "payment_date", nullable = false)
    private Date paymentDate; // Date and time of payment

}
