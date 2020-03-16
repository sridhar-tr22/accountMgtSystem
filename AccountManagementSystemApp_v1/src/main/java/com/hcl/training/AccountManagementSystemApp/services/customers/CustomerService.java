package com.hcl.training.AccountManagementSystemApp.services.customers;

import org.springframework.stereotype.Service;

import com.hcl.training.AccountManagementSystemApp.entities.RequestObjects;

@Service
public interface CustomerService {
	
	public void createCustomerAndAssociateAccount(RequestObjects personalRequestObjects) throws Exception;

}
