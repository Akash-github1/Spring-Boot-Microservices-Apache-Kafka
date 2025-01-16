package com.atd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.atd.entities.data_search_model;

public interface DataSearchRepository extends JpaRepository<data_search_model, Long> {

    @Query("SELECT a FROM data_search_model a WHERE " +
           "(:email IS NULL OR a.email = :email) AND " +
           "(:companyName IS NULL OR a.company = :companyName) AND " +
           "(:country IS NULL OR a.country = :country) AND " +
           "(:role IS NULL OR a.role = :role) AND " +
           "(:partyId IS NULL OR a.partyId = :partyId) AND " +
           "(:includeBranches IS NULL OR a.includedBranches = :includeBranches)")
    List<data_search_model> findByDynamicCriteria(
            @Param("email") String email,
            @Param("companyName") String companyName,
            @Param("country") String country,
            @Param("role") String role,
            @Param("partyId") String partyId,
            @Param("includeBranches") String includeBranches);
    
    
    @Query("SELECT a FROM data_search_model a WHERE " +
            "(:email IS NULL OR a.email = :email) AND " +
            "(:companyName IS NULL OR a.company = :companyName)")
    List<data_search_model> getAll(
            @Param("email") String email,
            @Param("companyName") String companyName);
    
    
}
