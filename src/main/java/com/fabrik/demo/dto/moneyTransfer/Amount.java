package com.fabrik.demo.dto.moneyTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Amount {

	@JsonProperty(value = "debtorAmount")
	private Long debtorAmount;
	@JsonProperty(value = "debtorCurrency")
	private String debtorCurrency;
	@JsonProperty(value = "creditorAmount")
	private Long creditorAmount;
	@JsonProperty(value = "creditorCurrency")
	private String creditorCurrency;
	@JsonProperty(value = "creditorCurrencyDate")
	private String creditorCurrencyDate;
	@JsonProperty(value = "exchangeRate")
	private Long exchangeRate;
}