package com.fabrik.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fabrik.demo.dto.ApiErrorResponse;
import com.fabrik.demo.exception.AccountTransactionsException;
import com.fabrik.demo.exception.CashAccountException;
import com.fabrik.demo.exception.MoneyTransferException;

@ControllerAdvice
public class MainControllerAdvice extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainControllerAdvice.class);

	@ExceptionHandler(value = { AccountTransactionsException.class, CashAccountException.class,
			MoneyTransferException.class })
	protected ResponseEntity<ApiErrorResponse> apiException(RuntimeException ex, WebRequest request) {
		LOGGER.error("apiException >> ");
		ApiErrorResponse error = new ApiErrorResponse();
		error.setDescription(ex.getMessage());
		LOGGER.error("apiException >> {}", ex.getMessage());
		LOGGER.error("apiException <<");
		return new ResponseEntity<ApiErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
	
}
