package com.fabrik.demo.dto.accounttransactions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountTransactionType {

	@JsonProperty(value = "enumeration")
	private String enumeration;
	@JsonProperty(value = "value")
	private String value;

}
