package com.atd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DataSearchModelDTO {

    @JsonProperty("email")
    private String email;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("country")
    private String country;

    @JsonProperty("role")
    private String role;

    @JsonProperty("partyId")
    private String partyId;

    @JsonProperty("includeBranches")
    private String includeBranches;
}