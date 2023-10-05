package com.fabrik.demo.dto.moneyTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
public class Debtor {
	
	@JsonProperty(value = "name")
	private String name;
	@JsonProperty(value = "account")
    private Account account;
}
