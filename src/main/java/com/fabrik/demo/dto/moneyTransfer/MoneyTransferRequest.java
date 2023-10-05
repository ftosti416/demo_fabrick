package com.fabrik.demo.dto.moneyTransfer;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
public class MoneyTransferRequest {
	
    @JsonProperty(value = "creditor")
    @Valid
    private Creditor creditor;
    @JsonProperty(value = "executionDate")
    private String executionDate;
    @JsonProperty(value = "uri")
    private String uri;
    @JsonProperty(value = "description")
    @Size(max = 140)
    private String description;
    @JsonProperty(value = "amount")
    private Long amount;
    @JsonProperty(value = "currency")
    private String currency;
    @JsonProperty(value = "isUrgent")
    private boolean isUrgent;
    @JsonProperty(value = "isInstant")
    private boolean isInstant;
    @JsonProperty(value = "feeType")
    private String feeType;
    @JsonProperty(value = "feeAccountId")
    private String feeAccountId;
    @JsonProperty(value = "taxRelief")
    @Valid
    private TaxRelief taxRelief;

}