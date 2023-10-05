package com.fabrik.demo.exception;

import org.springframework.http.HttpStatus;

public class MoneyTransferException extends ApiGenericException {

	private static final long serialVersionUID = -1539894892148772066L;

	public MoneyTransferException(HttpStatus status, String code, String errorMessage) {
		super(status, code, errorMessage);
	}

}
