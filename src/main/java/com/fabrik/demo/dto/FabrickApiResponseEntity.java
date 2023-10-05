package com.fabrik.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FabrickApiResponseEntity<T> {

	@JsonProperty(value = "status")
	private String status;
	
	@JsonProperty(value = "errors")
	private List<ApiErrorResponse> errors;
	
	@JsonProperty(value = "payload")
	private T payload;
}
