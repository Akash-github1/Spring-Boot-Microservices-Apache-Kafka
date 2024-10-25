package com.atd.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "supergroup_program_type")
    private String supergroupProgramType; // renamed for consistency

    @Column(name = "agent")
    private String agent;

    @Column(name = "gbid")
    private String gbid;

    @Column(name = "coverage_level")
    private String coverageLevel; // renamed for consistency

    @Column(name = "country_code")
    private String countryCode; // renamed for consistency

    @Column(name = "supergroup_name")
    private String supergroupName; // renamed for consistency

    @Column(name = "country")
    private String country;

    @Column(name = "sfdc_owner")
    private String sfdcOwner; // renamed for consistency

    @Column(name = "timestamp")
    private String timestamp; // Using String for simplicity
    
    @Column(name = "customer")
    private String customer;

    @Column(name = "incBranchLoc")
    private String incBranchLoc;

    @Column(name = "city")
    private String city;

    @Column(name = "rm_team_name")
    private String rmTeamName; // renamed for consistency

    @Column(name = "rm_email")
    private String rmEmail; // renamed for consistency

    @Column(name = "savid")
    private String savid;

    @Column(name = "team_name")
    private String teamName; // renamed for consistency

    @Column(name = "region")
    private String region;

    @Column(name = "version")
    private String version; // renamed for consistency

    @Column(name = "sfdc_account_id")
    private String sfdcAccountId;

    @Column(name = "role")
    private String role;

    @Column(name = "party_id")
    private String partyId; // renamed for consistency

    @Column(name = "rm_name")
    private String rmName; // renamed for consistency

    @Column(name = "supergroup_id")
    private String supergroupId; // renamed for consistency

    @Column(name = "eac_account_name")
    private String eacAccountName; // renamed for consistency

    @Column(name = "site_type")
    private String siteType; // renamed for consistency

    @Column(name = "eac_organisation_name")
    private String eacOrganisationName; // renamed for consistency

    @Column(name = "postal_code")
    private String postalCode; // renamed for consistency

    @Column(name = "sav_name")
    private String savName; // renamed for consistency

    @Column(name = "sfdc_account_name")
    private String sfdcAccountName; // renamed for consistency

    @Column(name = "state")
    private String state;
}
