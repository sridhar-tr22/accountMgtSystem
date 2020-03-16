package com.hcl.training.AccountManagementSystemApp.entities.accounts;

import java.math.BigDecimal;

public class AddFundsToAccountRequestObject {

	private String accountNumber;
	private BigDecimal ammountToAdd;
	
	public AddFundsToAccountRequestObject() {}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getAmmountToAdd() {
		return ammountToAdd;
	}

	public void setAmmountToAdd(BigDecimal ammountToAdd) {
		this.ammountToAdd = ammountToAdd;
	}
	
}
