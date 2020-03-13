package com.hcl.training.AccountManagementSystemApp.repository.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.Customer;
import com.hcl.training.AccountManagementSystemApp.entities.utils.AccountConstants;
import com.hcl.training.AccountManagementSystemApp.foundations.AccountNumberGenerator;
import com.hcl.training.AccountManagementSystemApp.foundations.CustomerNumberGenerator;
import com.hcl.training.AccountManagementSystemApp.repository.CustomerRepository;
import com.hcl.training.AccountManagementSystemApp.repository.CustomizedCustomerRepository;

public class CustomizedCustomerRepositoryImpl implements CustomizedCustomerRepository {

	@Autowired
	@Lazy
	private CustomerRepository customerRepository;

	public CustomizedCustomerRepositoryImpl() {}
	
	@Override
	public void createCustomerAndLinkAccount(Customer customer, Account account) {
		try {
			Account acc = account;
			acc.setAccountStatus(AccountConstants.ACCOUNT_STATUS_ACTIVE);
			acc.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
			customer.setCustomerId(CustomerNumberGenerator.generateAccountNumber());
			customer.linksAnAccountWithThisCustomer(acc);
			
			customerRepository.save(customer);
		} catch (Exception e) {
		}
	}
}
