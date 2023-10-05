package com.fabrik.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiErrorResponse {

	@JsonProperty(value = "code")
	private String code;
	@JsonProperty(value = "description")
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
