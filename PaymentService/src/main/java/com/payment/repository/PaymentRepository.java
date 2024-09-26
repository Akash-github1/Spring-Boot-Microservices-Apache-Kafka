package com.payment.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.payment.entities.PaymentConfirmationEntity;

public interface PaymentRepository extends JpaRepository<PaymentConfirmationEntity, String> {
//    Optional<PaymentConfirmationEntity> findByorderId(String orderId);
}
