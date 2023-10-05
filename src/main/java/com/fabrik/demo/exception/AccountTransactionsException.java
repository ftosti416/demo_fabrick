package com.fabrik.demo.exception;

import org.springframework.http.HttpStatus;

public class AccountTransactionsException extends ApiGenericException {

	private static final long serialVersionUID = -2685811836212531168L;

	public AccountTransactionsException(HttpStatus status, String code, String errorMessage) {
		super(status, code, errorMessage);
	}

}
