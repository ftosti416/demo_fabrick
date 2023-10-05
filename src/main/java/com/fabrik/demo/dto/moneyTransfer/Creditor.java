package com.fabrik.demo.dto.moneyTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Creditor {

	@JsonProperty(value = "name")
	@Size(max = 70)
	@NotNull
	private String name;
	@JsonProperty(value = "account")
	@Valid
	@NotNull
	private Account account;
	@JsonProperty(value = "address")
	@Valid
	private Address address;
}
