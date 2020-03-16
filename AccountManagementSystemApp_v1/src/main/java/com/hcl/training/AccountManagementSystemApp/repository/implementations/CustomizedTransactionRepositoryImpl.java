package com.hcl.training.AccountManagementSystemApp.repository.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.hcl.training.AccountManagementSystemApp.entities.RequestObjects;
import com.hcl.training.AccountManagementSystemApp.entities.transactions.CreditTransactionRequest;
import com.hcl.training.AccountManagementSystemApp.repository.CustomizedTransactionRepository;
import com.hcl.training.AccountManagementSystemApp.repository.TransactionRepository;

public class CustomizedTransactionRepositoryImpl implements CustomizedTransactionRepository {
	
	@Autowired
	@Lazy
	private TransactionRepository transactionRepository;

	@Override
	public void recordTransactionForCreditOperation(RequestObjects request) {
		CreditTransactionRequest creditTransactionRequest = null;
		
		if(request instanceof CreditTransactionRequest) {
			creditTransactionRequest = (CreditTransactionRequest)request;
			
			//transactionRepository.save()
			
			
		}

	}

	@Override
	public void recordTransactionForDebitOperation(RequestObjects request) {
		// TODO Auto-generated method stub

	}

}
