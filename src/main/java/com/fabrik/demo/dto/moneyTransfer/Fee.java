package com.fabrik.demo.dto.moneyTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Fee {

	@JsonProperty(value = "feeCode")
	private String feeCode;
	@JsonProperty(value = "description")
	private String description;
	@JsonProperty(value = "amount")
	private Long amount;
	@JsonProperty(value = "currency")
	private String currency;
}
