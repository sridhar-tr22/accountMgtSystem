package com.hcl.training.AccountManagementSystemApp.repository;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.AddFundsToAccountRequestObject;

public interface CustomizedAccountRepository {
	
	public void fetchAllByIFSC(String IFSC);
	
	public void addFundsToAccount(AddFundsToAccountRequestObject requestObject);
}
