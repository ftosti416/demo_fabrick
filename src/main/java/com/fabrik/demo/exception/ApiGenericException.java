package com.fabrik.demo.exception;

import org.springframework.http.HttpStatus;

public class ApiGenericException extends RuntimeException {

	private static final long serialVersionUID = -8663304149993906452L;

	private HttpStatus status;
	private String code;

	public ApiGenericException(HttpStatus status, String code, String errorMessage) {
		super(errorMessage);
		setStatus(status);
		setCode(code);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
