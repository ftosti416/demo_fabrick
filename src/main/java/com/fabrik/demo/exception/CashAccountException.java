package com.fabrik.demo.exception;

import org.springframework.http.HttpStatus;

public class CashAccountException extends ApiGenericException {

	private static final long serialVersionUID = -2086683131166045788L;

	public CashAccountException(HttpStatus status, String code, String errorMessage) {
		super(status, code, errorMessage);
	}

}
