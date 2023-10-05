package com.fabrik.demo.dto.moneyTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
	
    @JsonProperty(value = "address")
    @Size(max = 40)
	private String address;
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "countryCode")
    private String countryCode;
}
