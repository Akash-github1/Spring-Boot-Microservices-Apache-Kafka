package com.atd.controller;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atd.entities.AccountSearchDTO;
import com.atd.entities.Accounts;
import com.atd.repository.AccountSearchRepository;

@RestController
@RequestMapping("/accounts")
public class AccountController  {

    @Autowired
    private AccountSearchRepository accountSearchRepository;

    @PostMapping("/search")
    public ResponseEntity<?> searchAccounts(@RequestBody AccountSearchDTO searchDTO) {
        // Log the incoming search DTO for debugging
        System.out.println("Search Criteria: " + searchDTO);

        // Search by the criteria provided in the DTO
        List<Accounts> accounts = accountSearchRepository.findByCriteria(
//            searchDTO.getPropName(),
            searchDTO.getPropValue(),
            searchDTO.getGbids() // Include gbids in the search criteria
        );

        // Prepare the response structure
        Map<String, Object> response = new HashMap<>();
        response.put("took", 27);
        response.put("timed_out", false);
        
        Map<String, Object> shards = new HashMap<>();
        shards.put("total", 1);
        shards.put("successful", 1);
        shards.put("skipped", 0);
        shards.put("failed", 0);
        response.put("_shards", shards);
        
        Map<String, Object> totalHits = new HashMap<>();
        totalHits.put("value", accounts.size());
        totalHits.put("relation", "eq");
        
        Map<String, Object> hits = new HashMap<>();
        hits.put("total", totalHits);
        hits.put("max_score", 1.0); // Adjust as necessary
        hits.put("hits", accounts);
        
        response.put("hits", hits);
        
        // Return appropriate response
        return accounts.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
}
