package com.atd.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "data_search_model")
@Data
public class data_search_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "sg_program")
    private String sgProgram; // Renamed for "sgProgram"

    @Column(name = "agent")
    private String agent;

    @Column(name = "gb_id")
    private String gbIds; // Renamed for consistency with "gbId"

    @Column(name = "coverage_level")
    private String coverageLevel;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "sg_name")
    private String sgName; // Renamed for consistency with "sgName"

    @Column(name = "country")
    private String country;

    @Column(name = "sfdc_owner")
    private String sfdcOwner;

    @Column(name = "timestamp")
    private String timestamp;

    @Column(name = "customer")
    private String customer;

    @Column(name = "included_branches")
    private String includedBranches; // Renamed for consistency with "includedBranches"

    @Column(name = "city")
    private String city;

    @Column(name = "county")
    private String county; // Added for "county"

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "team_name")
    private String teamName;

    @Column(name = "region")
    private String region;

    @Column(name = "party_id")
    private String partyId;

    @Column(name = "sfdc_account_name")
    private String sfdcAccountName;

    @Column(name = "sfdc_account_id")
    private String sfdcAccountId;

    @Column(name = "state")
    private String state;

    @Column(name = "company")
    private String company; // Added for "company"

    @Column(name = "job_title")
    private String jobTitle; // Added for "jobTitle"

    @Column(name = "team_member_name")
    private String teamMemberName; // Added for "teamMemberName"

    @Column(name = "sales_acct_id")
    private String salesAcctId; // Added for "salesAcctId"

    @Column(name = "role")
    private String role;

    @Column(name = "sg_id")
    private String sgId; // Renamed for "sgId"
}
