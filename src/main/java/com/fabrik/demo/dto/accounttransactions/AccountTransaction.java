package com.fabrik.demo.dto.accounttransactions;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountTransaction {

	@JsonProperty(value = "transactionId")
	private String transactionId;
	@JsonProperty(value = "operationId")
	private String operationId;
	@JsonProperty(value = "accountingDate")
	private String accountingDate;
	@JsonProperty(value = "valueDate")
	private String valueDate;
	@JsonProperty(value = "type")
	private AccountTransactionType type;
	@JsonProperty(value = "amount")
	private Long amount;
	@JsonProperty(value = "currency")
	private String currency;
	@JsonProperty(value = "description")
	private String description;

}
