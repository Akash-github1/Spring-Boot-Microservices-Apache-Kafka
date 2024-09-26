package com.endUser.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.endUser.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByorderId(String orderId);
}
