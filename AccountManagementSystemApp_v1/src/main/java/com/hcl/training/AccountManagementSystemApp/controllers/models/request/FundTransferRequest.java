package com.hcl.training.AccountManagementSystemApp.controllers.models.request;

import java.math.BigDecimal;

/**
 * @author User1
 * 
 * This represents the fund transfer request.
 */
public class FundTransferRequest {

	private String typeOfTransfer;
	private String fromAccount;
	private String beneficiaryAccount;
	private BigDecimal amount;
	
	public FundTransferRequest() {}

	public String getTypeOfTransfer() {
		return typeOfTransfer;
	}

	public void setTypeOfTransfer(String typeOfTransfer) {
		this.typeOfTransfer = typeOfTransfer;
	}

	public String getFromAccount() {
		return fromAccount;
	}

	public void setFromAccount(String fromAccount) {
		this.fromAccount = fromAccount;
	}

	public String getBeneficiaryAccount() {
		return beneficiaryAccount;
	}

	public void setBeneficiaryAccount(String beneficiaryAccount) {
		this.beneficiaryAccount = beneficiaryAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
