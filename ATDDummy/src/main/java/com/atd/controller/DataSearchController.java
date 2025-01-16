package com.atd.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.atd.entities.DataSearchModelDTO;
import com.atd.entities.data_search_model;
import com.atd.repository.DataSearchRepository;

import java.util.*;

@RestController
@RequestMapping("/data")
public class DataSearchController {

    @Autowired
    private DataSearchRepository dataSearchRepository;

    @PostMapping("/search")
    public ResponseEntity<?> getMemberInfo(@RequestBody DataSearchModelDTO dataSearchModelDTO) {
        // Extract fields from DTO
//        String email = dataSearchModelDTO.getEmail();
//        String companyName = dataSearchModelDTO.getCompanyName();
//        String country = dataSearchModelDTO.getCountry();
//        String role = dataSearchModelDTO.getRole();
//        String partyId = dataSearchModelDTO.getPartyId();
//        String includeBranches = dataSearchModelDTO.getIncludeBranches();
        String searchQuery = dataSearchModelDTO.getSearchQuery();

        // Perform search based on provided fields
        List<data_search_model> searchedData = dataSearchRepository.findByDynamicSearchQuery(searchQuery);
        System.out.println("dataSearchModelDTO : " + dataSearchModelDTO.getSearchQuery());
        System.out.println("searchedData : " + searchedData);
        // Transform data for response
        List<Map<String, Object>> memberInfoList = new ArrayList<>();
        for (data_search_model data : searchedData) {
            Map<String, Object> memberInfo = new HashMap<>();
            memberInfo.put("role", data.getRole());
            memberInfo.put("region", data.getRegion());
            memberInfo.put("email", data.getEmail());
            memberInfo.put("city", data.getCity());
            memberInfo.put("county", data.getCountry());
            memberInfo.put("state", data.getState());
            memberInfo.put("company", data.getCustomer());
            memberInfo.put("teamName", data.getTeamName() == null ? " " : data.getTeamName());
            memberInfo.put("jobTitle", null);
            memberInfo.put("partyId", data.getPartyId());
            memberInfo.put("teamMemberName", null);
            memberInfo.put("salesAcctId", null);
            memberInfo.put("accountName", null);
            memberInfo.put("includedBranches", data.getIncludedBranches());
            memberInfo.put("sfdcAccountName", data.getSfdcAccountName());
            memberInfo.put("sfdcOwner", data.getSfdcOwner());
            memberInfo.put("sfdcAccountId", data.getSfdcAccountId());
            memberInfo.put("postalCode", data.getPostalCode());
            memberInfo.put("gbId", data.getGbIds());
            memberInfo.put("countryCode", data.getCountryCode());
            memberInfo.put("coverageLevel", data.getCoverageLevel());
            memberInfo.put("sgId", data.getSgId());
            memberInfo.put("sgName", data.getSgName());
            memberInfo.put("sgProgram", data.getSgProgram());
            memberInfoList.add(memberInfo);
        }

        // Build response structure
        Map<String, Object> dataArea = new HashMap<>();
        Map<String, Object> acknowledge = new HashMap<>();
        acknowledge.put("reasonCode", 0);
        acknowledge.put("reasonMsg", "SUCCESS");
        acknowledge.put("failureMsg", null);

        Map<String, Object> memberInfoData = new HashMap<>();
        memberInfoData.put("memberInfo", memberInfoList);

        dataArea.put("acknowledge", acknowledge);
        dataArea.put("memberInfoData", memberInfoData);

        Map<String, Object> response = new HashMap<>();
        response.put("dataArea", dataArea);

        return ResponseEntity.ok(response);
    }
}
