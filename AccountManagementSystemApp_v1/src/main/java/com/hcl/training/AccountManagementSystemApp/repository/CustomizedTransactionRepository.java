package com.hcl.training.AccountManagementSystemApp.repository;

import com.hcl.training.AccountManagementSystemApp.entities.RequestObjects;

public interface CustomizedTransactionRepository {

	void recordTransactionForCreditOperation(RequestObjects requestObjects);
	void recordTransactionForDebitOperation(RequestObjects requestObjects);
}
