package com.hcl.training.AccountManagementSystemApp.repository;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.Customer;

public interface CustomizedCustomerRepository {

	public void createCustomerAndLinkAccount(Customer customer, Account account);
}
