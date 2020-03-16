package com.hcl.training.AccountManagementSystemApp.repository.implementations;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.entities.accounts.AddFundsToAccountRequestObject;
import com.hcl.training.AccountManagementSystemApp.entities.accounts.DeductFundFromAccountRequestObject;
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

	/**
	 * adds funds the account
	 */
	public void addFundsToAccount(AddFundsToAccountRequestObject requestObject) {
		
		Optional<Account> findById = accountRepository.findById(requestObject.getAccountNumber());
		Account fetchedForUpdate = findById.get();
		BigDecimal currentBalance = fetchedForUpdate.getAccountBalanceAmount();
		BigDecimal creditedBalance = currentBalance.add(requestObject.getAmmountToAdd());
		
		fetchedForUpdate.setAccountBalanceAmount(creditedBalance);
		Account saved = accountRepository.save(fetchedForUpdate);
	}
	
	public void deductFundFromAccount(DeductFundFromAccountRequestObject deductFundFromAccountRequestObject) {
	
		Account findByAccountNumber = accountRepository.findByAccountNumber(deductFundFromAccountRequestObject.getAccountNumber());
		BigDecimal currentBalance = findByAccountNumber.getAccountBalanceAmount();
		BigDecimal debitedBalance = currentBalance.subtract(deductFundFromAccountRequestObject.getDeductAmount());
		findByAccountNumber.setAccountBalanceAmount(debitedBalance);
		accountRepository.save(findByAccountNumber);
	}
}
