package com.hcl.training.AccountManagementSystemApp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionRepositoryTest {

	@Autowired
	private TransactionRepository transactionRepository; 
	
	@Autowired
	private AccountRepository accountRepository;
	
	@BeforeEach
	public void setup() {
		
	}
	
	@Test
	public void sendMoneyTest() {
		
		
		
	}
}
