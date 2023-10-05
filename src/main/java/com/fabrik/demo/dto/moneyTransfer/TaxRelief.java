package com.fabrik.demo.dto.moneyTransfer;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaxRelief {

	@JsonProperty(value = "taxReliefId")
	private String taxReliefId;
	@JsonProperty(value = "isCondoUpgrade")
	@NotNull
	private boolean isCondoUpgrade;
	@JsonProperty(value = "creditorFiscalCode")
	@NotNull
	private String creditorFiscalCode;
	@JsonProperty(value = "beneficiaryType")
	@NotNull
	private String beneficiaryType;
	@JsonProperty(value = "naturalPersonBeneficiary")
	@Valid
	private NaturalPersonBeneficiary naturalPersonBeneficiary;
	@JsonProperty(value = "legalPersonBeneficiary")
	@Valid
	private LegalPersonBeneficiary legalPersonBeneficiary;
}
