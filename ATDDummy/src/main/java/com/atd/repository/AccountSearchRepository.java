package com.atd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.atd.entities.Accounts;

public interface AccountSearchRepository extends JpaRepository<Accounts, Long> {
    
    // Custom multi-criteria search focused on selected account, gbids, and branch
    @Query("SELECT a FROM Accounts a " +
           "WHERE (a.customer = :propValue) " + // Match propValue to customer
           "AND a.country = :gbids") // Filter by gbids (country)
    List<Accounts> findByCriteria(
//        @Param("propName") String propName,
        @Param("propValue") String propValue,
        @Param("gbids") String gbids // Include gbids parameter
    );
}
