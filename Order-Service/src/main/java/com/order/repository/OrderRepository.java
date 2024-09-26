package com.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.entities.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
    Optional<Order> findByorderId(String orderId);
}
