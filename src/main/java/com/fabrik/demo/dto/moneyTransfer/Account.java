package com.fabrik.demo.dto.moneyTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
public class Account {
	
	@JsonProperty(value = "accountCode")
	@NotNull
	private String accountCode;
	@JsonProperty(value = "bicCode")
    private String bicCode;
}