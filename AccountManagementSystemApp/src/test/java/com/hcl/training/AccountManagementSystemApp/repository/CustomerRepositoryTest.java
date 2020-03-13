package com.hcl.training.AccountManagementSystemApp.repository;

import java.time.chrono.IsoChronology;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.Customer;
import com.hcl.training.AccountManagementSystemApp.entities.utils.AccountConstants;
import com.hcl.training.AccountManagementSystemApp.foundations.AccountNumberGenerator;

@DataJpaTest
public class CustomerRepositoryTest {
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void createCustomeAndLinkAccount() {
		
		Account savingAccount = new Account();
		savingAccount.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
		savingAccount.setAccountStatus(AccountConstants.ACCOUNT_STATUS_ACTIVE);
		savingAccount.setAccountType(AccountConstants.ACCOUNT_TYPE_SAVING);
		savingAccount.setIFSC(AccountConstants.ACCOUNT_IFSC);
		
		Account currentAccount = new Account();
		currentAccount.setAccountNumber(AccountNumberGenerator.generateAccountNumber());
		currentAccount.setAccountStatus(AccountConstants.ACCOUNT_STATUS_ACTIVE);
		currentAccount.setAccountType(AccountConstants.ACCOUNT_TYPE_CURRENT);
		currentAccount.setIFSC(AccountConstants.ACCOUNT_IFSC);
		
		Customer customer = new Customer();
		customer.setCustomerId("Cust001");
		customer.setName("Cust_name");
		customer.setAddress("123, Bengaluru");
		customer.setEmail("customer@sample.org");
		customer.setBirthDay(IsoChronology.INSTANCE.date(2000, 1, 15));
		customer.setEligible(true);
		
		customer.linksAnAccountWithThisCustomer(savingAccount);
		customer.linksAnAccountWithThisCustomer(currentAccount);
		
		
		  /*
		   * testEntityManager.persist(customer);
		   * testEntityManager.flush();
		   * Customer fetchedCustomer = testEntityManager.find(Customer.class,"Cust001");
		   * 
		   */
			
		  //accountRepository.save(savingAccount);
		  //accountRepository.save(currentAccount);
		
		 // customerRepository.save(customer);
		  
		  customerRepository.createCustomerAndLinkAccount(customer, savingAccount);
		  
		  Optional<Customer> findById = customerRepository.findById("Cust001");
		  
		  Customer fetchedCustomer = findById.get();
		 
		  System.out.println(fetchedCustomer.getCustomerId());
		  System.out.println(fetchedCustomer.getAddress());
		  System.out.println(fetchedCustomer.getName());
		  List<Account> accounts = fetchedCustomer.getAccounts();
		  System.out.println(accounts);
		  System.out.println(accounts.size());
	
	}
	

}
