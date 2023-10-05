package com.fabrik.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fabrik.demo.dto.FabrickApiResponseEntity;
import com.fabrik.demo.dto.accounttransactions.AccountTransactionsResponse;
import com.fabrik.demo.dto.cashaccount.CashAccountResponse;
import com.fabrik.demo.dto.moneyTransfer.MoneyTransferRequest;
import com.fabrik.demo.dto.moneyTransfer.MoneyTransferResponse;
import com.fabrik.demo.exception.AccountTransactionsException;
import com.fabrik.demo.exception.CashAccountException;
import com.fabrik.demo.exception.MoneyTransferException;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/api")
public class MainController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

	@Value("${app.api.cashAccount.fullPath}")
	private String cashAccountUrl;
	@Value("${app.api.moneyTransfer.fullPath}")
	private String moneyTransferUrl;
	@Value("${app.api.accountTransactions.fullPath}")
	private String accountTransactionsUrl;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/cashAccount")
	public ResponseEntity<FabrickApiResponseEntity<CashAccountResponse>> getCashAccount() {

		ResponseEntity<FabrickApiResponseEntity<CashAccountResponse>> response = null;
		LOGGER.info("getCashAccount >> START");
		try {
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> request = new HttpEntity<String>(headers);
			response = restTemplate.exchange(cashAccountUrl, HttpMethod.GET, request,
					new ParameterizedTypeReference<FabrickApiResponseEntity<CashAccountResponse>>() {
					});
			LOGGER.info("getCashAccount >> response : {}", response);
		} catch (Exception e) {
			throw new CashAccountException(HttpStatus.INTERNAL_SERVER_ERROR, "500", e.getMessage());
		}
		LOGGER.info("getCashAccount << END");
		return response;
	}

	@PostMapping("/moneyTransfer")
	public ResponseEntity<FabrickApiResponseEntity<MoneyTransferResponse>> postMoneyTransfer(
			@RequestBody @Valid MoneyTransferRequest body) {

		ResponseEntity<FabrickApiResponseEntity<MoneyTransferResponse>> response = null;
		LOGGER.info("postMoneyTransfer >> START");
		try {
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<?> request = new HttpEntity<MoneyTransferRequest>(body, headers);
			response = restTemplate.exchange(moneyTransferUrl, HttpMethod.POST, request,
					new ParameterizedTypeReference<FabrickApiResponseEntity<MoneyTransferResponse>>() {
					});
			LOGGER.info("postMoneyTransfer >> response : {}", response);
		} catch (Exception e) {
			throw new MoneyTransferException(HttpStatus.INTERNAL_SERVER_ERROR, "500", e.getMessage());
		}
		LOGGER.info("postMoneyTransfer << END");
		return response;
	}

	@Value("${app.api.accountTransactions.param.from}")
	private String fromAccountingDate;
	@Value("${app.api.accountTransactions.param.to}")
	private String toAccountingDate;

	@GetMapping("/accountTransactions")
	public ResponseEntity<FabrickApiResponseEntity<AccountTransactionsResponse>> getAccountTransactions(
			@RequestParam String fromAccountingDate, @RequestParam String toAccountingDate) {

		ResponseEntity<FabrickApiResponseEntity<AccountTransactionsResponse>> response = null;
		LOGGER.info("getAccountTransactions >> START");
		try {
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<String> request = new HttpEntity<String>(headers);
			String urlQuery = UriComponentsBuilder.fromHttpUrl(accountTransactionsUrl)
					.queryParam(this.fromAccountingDate, fromAccountingDate)
					.queryParam(this.toAccountingDate, toAccountingDate).encode().toUriString();
			Map<String, String> params = new HashMap<String, String>();
			params.put(this.fromAccountingDate, fromAccountingDate);
			params.put(this.toAccountingDate, toAccountingDate);
			response = restTemplate.exchange(urlQuery, HttpMethod.GET, request,
					new ParameterizedTypeReference<FabrickApiResponseEntity<AccountTransactionsResponse>>() {
					}, params);
			LOGGER.info("getAccountTransactions >> response : {}", response);
		} catch (Exception e) {
			throw new AccountTransactionsException(HttpStatus.INTERNAL_SERVER_ERROR, "500", e.getMessage());
		}
		LOGGER.info("getAccountTransactions << END");
		return response;
	}
}
