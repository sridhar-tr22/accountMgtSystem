package com.hcl.training.AccountManagementSystemApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.hcl.training.AccountManagementSystemApp.repository.CustomizedAccountRepository;
import com.hcl.training.AccountManagementSystemApp.repository.implementations.CustomizedAccountRepositoryImpl;

@SpringBootTest
class AccountManagementSystemAppApplicationTests {

	@Test
	void contextLoads() {
	}

	@Bean
	public CustomizedAccountRepository getInstance() {
		return new CustomizedAccountRepositoryImpl();
	}
}
