package com.hcl.training.AccountManagementSystemApp.repository.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.entities.accounts.AddFundsToAccountRequestObject;
import com.hcl.training.AccountManagementSystemApp.repository.AccountRepository;
import com.hcl.training.AccountManagementSystemApp.repository.CustomizedAccountRepository;

public class CustomizedAccountRepositoryImpl implements CustomizedAccountRepository {
	
	@Autowired
	private AccountRepository accountRepository; 
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void fetchAllByIFSC(String IFSC) {
		
	}

	@Override
	public void transferFunds(AddFundsToAccountRequestObject requestObject) {
		Account account = new Account();
		account.setAccountNumber(requestObject.getAccountNumber());
		account.setAccountBalanceAmount(requestObject.getAmmountToAdd());
		accountRepository.save(account);
	}

}
