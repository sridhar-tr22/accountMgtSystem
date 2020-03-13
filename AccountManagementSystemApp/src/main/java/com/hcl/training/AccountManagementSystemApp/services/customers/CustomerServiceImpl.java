package com.hcl.training.AccountManagementSystemApp.services.customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.training.AccountManagementSystemApp.entities.RequestObjects;
import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.Customer;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.CustomerPersonalDetailsReqObj;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.CustomersAccountDetailsReqObj;
import com.hcl.training.AccountManagementSystemApp.repository.CustomerRepository;
import com.hcl.training.AccountManagementSystemApp.services.exceptions.FaultException;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	  @Autowired private CustomerRepository customerRepository;
	 

	@Override
	public void createCustomerAndAssociateAccount(RequestObjects customerPersonalDetailsReqObject) throws Exception {
		
		CustomerPersonalDetailsReqObj requestObjectPersonal = null;
		CustomersAccountDetailsReqObj requestObjectAccount = null;
		
		Customer customer = new Customer();
		Account account = new Account();
		
		try {
				if(customerPersonalDetailsReqObject != null) 
				{
					if(customerPersonalDetailsReqObject instanceof CustomerPersonalDetailsReqObj) 
					{
						requestObjectPersonal = (CustomerPersonalDetailsReqObj) customerPersonalDetailsReqObject;
					}
					
					customer.setName(requestObjectPersonal.getName());
					customer.setAddress(requestObjectPersonal.getAddress());
					customer.setPhone(requestObjectPersonal.getPhone());
					customer.setEmail(requestObjectPersonal.getEmail());
					customer.setBirthDay(requestObjectPersonal.getBirthDay());
					customer.setEligible(requestObjectPersonal.getEligiblity());
					
					requestObjectAccount = requestObjectPersonal.getAccountDetailsReqObj();
					if(requestObjectAccount instanceof CustomersAccountDetailsReqObj) {
						account.setAccountStatus(requestObjectAccount.getAccountStatus());
						account.setAccountType(requestObjectAccount.getAccountType());
						account.setIFSC(requestObjectAccount.getIFSC());
					}
					
					customerRepository.createCustomerAndLinkAccount(customer, account);
					
				}
		}catch (Exception e) {
			throw new FaultException(e.getMessage(), e);
		}
	}
}
