package com.hcl.training.AccountManagementSystemApp.entities.accounts;

import java.math.BigDecimal;

public class DeductFundFromAccountRequestObject {

	private String accountNumber;
	private BigDecimal deductAmount;
	
	public DeductFundFromAccountRequestObject() {}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getDeductAmount() {
		return deductAmount;
	}

	public void setDeductAmount(BigDecimal deductAmount) {
		this.deductAmount = deductAmount;
	}
	
}
