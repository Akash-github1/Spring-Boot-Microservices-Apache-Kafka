package com.atd.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountSearchDTO {

    @JsonProperty("propName")
    private String propName;

    @JsonProperty("propValue")
    private String propValue;

    @JsonProperty("gbids")
    private String gbids;
    
    @JsonProperty("branch")
    private String incBranchLoc;
}
