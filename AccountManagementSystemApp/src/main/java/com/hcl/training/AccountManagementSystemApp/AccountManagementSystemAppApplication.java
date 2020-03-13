package com.hcl.training.AccountManagementSystemApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hcl.training.AccountManagementSystemApp.repository.CustomizedAccountRepository;
import com.hcl.training.AccountManagementSystemApp.repository.CustomizedCustomerRepository;
import com.hcl.training.AccountManagementSystemApp.repository.implementations.CustomizedAccountRepositoryImpl;
import com.hcl.training.AccountManagementSystemApp.repository.implementations.CustomizedCustomerRepositoryImpl;

@SpringBootApplication
public class AccountManagementSystemAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountManagementSystemAppApplication.class, args);
	}

	@Bean
	public CustomizedCustomerRepository getCustomerRepositoryInstance() {
		return new CustomizedCustomerRepositoryImpl();
	}
	
	@Bean
	public CustomizedAccountRepository getAccountRepositoryInstance() {
		return new CustomizedAccountRepositoryImpl();
	}
}
