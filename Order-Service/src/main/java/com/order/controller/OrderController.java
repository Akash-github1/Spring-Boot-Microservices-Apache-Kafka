package com.order.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.entities.Order;
import com.order.entities.OrderRequestDTO;
import com.order.entities.OrderStatusUpdateRequest;
import com.order.external.OrderDeliveryInterface;
import com.order.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private TaskScheduler taskScheduler;
    
    @Autowired
    OrderDeliveryInterface orderDeliveryInterface; // Feign client

    @Autowired
    private OrderRepository orderRepository; // Assuming you have an OrderRepository

//    @Autowired
//    private NotificationService notificationService; // Assuming you have a NotificationService

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequestDTO orderRequestDTO) {
    	System.out.println(orderRequestDTO);
    	// Generate a unique orderId using UUID
        String newOrderId = UUID.randomUUID().toString();

        // Create a new Order entity
        Order newOrder = new Order();
        newOrder.setOrderId(newOrderId);
        newOrder.setCustomerName(orderRequestDTO.getCustomerName());
        newOrder.setStatus("PENDING");
        newOrder.setRestaurantId(orderRequestDTO.getRestaurantId());
        newOrder.setTotalPrice(orderRequestDTO.getTotalPrice());

        // Save the new order to the database
        Order ordr = orderRepository.save(newOrder);
 
    	// Send order request to Kafka
        kafkaTemplate.send("order-topic", "Order requested with ID : " + ordr.getOrderId());
        
        // Immediately confirm the order after placement
        confirmOrder(ordr);

        return ResponseEntity.ok("Order placed successfully with orderId: " + newOrderId);
    }
    
    // Method to confirm the order
    public void confirmOrder(Order ordr) {
    	OrderStatusUpdateRequest updatestatus = new OrderStatusUpdateRequest();
    	updatestatus.setStatus("Confirmed");
    	
    	updateOrderStatus(ordr.getOrderId(), updatestatus);
        // Publish confirmation event to Kafka if needed
        kafkaTemplate.send("order-topic", "Order Placed Successfully");
        
     // Schedule location update after 10 seconds
        long delay = 8000; // 10 seconds
        taskScheduler.schedule(() -> updateDeliveryLocation(ordr.getOrderId()), new Date(System.currentTimeMillis() + delay).toInstant());    }

    // Method to update the delivery location
    public void updateDeliveryLocation(String orderId) {
    	OrderStatusUpdateRequest updatestatus = new OrderStatusUpdateRequest();
    	updatestatus.setStatus("On The Way");
    	
    	updateOrderStatus(orderId, updatestatus);
    	
    	kafkaTemplate.send("order-topic", "Order is on its way");
    	
    	ResponseEntity<Map<String, String>> response = orderDeliveryInterface.updateLocation();
        
    	System.out.println("Location updated response: " + response.getBody());
    }

    @PutMapping("/update-status/{orderId}")
    public ResponseEntity<String> updateOrderStatus(@PathVariable String orderId, @RequestBody OrderStatusUpdateRequest statusUpdateRequest) {
        // Find the order by orderId
        Order order = orderRepository.findById(orderId).get();

        if (order != null) {
            // Update the order status with the new status
            order.setStatus(statusUpdateRequest.getStatus());
            order.setPaymentId(statusUpdateRequest.getPaymentId());
            orderRepository.save(order);
            
//            kafkaTemplate.send("order-topic", order.toString());

            // Notify the customer that the order status has changed (e.g., payment confirmed)
//            notificationService.sendConfirmation(order);

            return ResponseEntity.ok("Order status updated successfully for orderId: " + orderId);
        } else {
            return ResponseEntity.badRequest().body("Order not found with orderId: " + orderId);
        }
    }
}
