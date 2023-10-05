package com.fabrik.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = MainController.class)
public class MainControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	RestTemplate restTemplate;

	private static final String CASH_ACCOUNT_URL = "/api/cashAccount";
	private static final String MONEY_TRANSFER_URL = "/api/moneyTransfer";
	private static final String ACCOUNT_TRANSACTIONS_URL = "/api/accountTransactions";

	private static final String MONEY_TRANSFER_PAYLOAD = "{\"creditor\":{\"name\":\"NAME\",\"account\":{\"accountCode\":\"IT23A0336844430152923804660\",\"bicCode\":\"SELBIT2BXXX\"},\"address\":{\"address\":null,\"city\":null,\"countryCode\":null}},\"executionDate\":\"2019-04-01\",\"uri\":\"REMITTANCE_INFORMATION\",\"description\":\"Paymentinvoice75/2017\",\"amount\":800,\"currency\":\"EUR\",\"isUrgent\":false,\"isInstant\":false,\"feeType\":\"SHA\",\"feeAccountId\":\"45685475\",\"taxRelief\":{\"taxReliefId\":\"L449\",\"isCondoUpgrade\":false,\"creditorFiscalCode\":\"56258745832\",\"beneficiaryType\":\"NATURAL_PERSON\",\"naturalPersonBeneficiary\":{\"fiscalCode1\":\"MRLFNC81L04A859L\",\"fiscalCode2\":null,\"fiscalCode3\":null,\"fiscalCode4\":null,\"fiscalCode5\":null},\"legalPersonBeneficiary\":{\"fiscalCode\":null,\"legalRepresentativeFiscalCode\":null}}}";

	@Test
	public void getCashAccountTest() throws Exception {
		mvc.perform(get(CASH_ACCOUNT_URL)).andExpect(status().isOk());
	}

	@Test
	public void getMoneyTransferNotAllowed() throws Exception {
		mvc.perform(get(MONEY_TRANSFER_URL)).andExpect(status().isMethodNotAllowed());
	}

	@Test
	public void postMoneyTransferFail() throws Exception {
		mvc.perform(post(MONEY_TRANSFER_URL)).andExpect(status().isBadRequest());
	}

	@Test
	public void postMoneyTransferValidationOk() throws Exception {
		mvc.perform(post(MONEY_TRANSFER_URL).contentType(MediaType.APPLICATION_JSON).content(MONEY_TRANSFER_PAYLOAD))
				.andExpect(status().isOk());
	}

	@Test
	public void getAccountTransactionsFail() throws Exception {
		mvc.perform(get(ACCOUNT_TRANSACTIONS_URL)).andExpect(status().isBadRequest());
	}

	@Test
	public void getAccountTransactionsOk() throws Exception {
		mvc.perform(get(ACCOUNT_TRANSACTIONS_URL).queryParam("fromAccountingDate", "2019-04-01")
				.queryParam("toAccountingDate", "2019-12-01")).andExpect(status().isOk());
	}

}
