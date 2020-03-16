package com.hcl.training.AccountManagementSystemApp.entities.cutomers;

import com.hcl.training.AccountManagementSystemApp.entities.RequestObjects;

public class CustomersAccountDetailsReqObj implements RequestObjects{
	
	private String accountNumber;
	private String IFSC;
	private String accountType;
	private String accountStatus;

	public CustomersAccountDetailsReqObj() {}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getIFSC() {
		return IFSC;
	}
	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

}
