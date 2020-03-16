package com.hcl.training.AccountManagementSystemApp.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.entities.accounts.AddFundsToAccountRequestObject;
import com.hcl.training.AccountManagementSystemApp.entities.utils.AccountConstants;
import com.hcl.training.AccountManagementSystemApp.foundations.AccountNumberGenerator;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class AccountRepostoryTest {

	private Account accountCreateTestData;
	private Account accountUpdateTestData;
	private Account accountDeleteTestData;
	private Account accountReadTestData;
	private Account differentIFSCTestData;
	
	
	@BeforeEach
	public void setup() {
		accountCreateTestData = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
		accountUpdateTestData = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
		accountDeleteTestData = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
		accountReadTestData = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
		differentIFSCTestData = new Account(AccountNumberGenerator.generateAccountNumber(), AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING, AccountConstants.ACCOUNT_STATUS_ACTIVE);
	}
	
	@Autowired
	private TestEntityManager testEntityManager;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Test
	public void createAccountTest() {
		
		/* tested using TestEntityManager */
		 	/* testEntityManager.persist(account);
		 	 *  Account find = testEntityManager.find(Account.class, 50001L);
		 	 * assertThat(find.getAccountNumber()).isEqualTo(account.getAccountNumber());
		 	 * assertThat(find.getAccountType()).isEqualTo(account.getAccountType());
		 	 */
		
		/* testing with the Account repository */
		System.out.println("Account Number from object: " +accountCreateTestData.getAccountNumber());
		accountRepository.save(accountCreateTestData);
		accountRepository.flush();
		Optional<Account> findById = accountRepository.findById(accountCreateTestData.getAccountNumber());
		
		if(findById.isPresent()) {
			assertThat(findById.get().getAccountNumber()).isEqualTo(accountCreateTestData.getAccountNumber());
		}
		
	}
	
	@Test
	public void updateAccountStatusTest() {

		accountRepository.save(accountUpdateTestData);
		accountRepository.flush();
		Optional<Account> findByIdForUpdate = accountRepository.findById(accountUpdateTestData.getAccountNumber());
		
		if(findByIdForUpdate.isPresent()) {
			
			Account updatableAccount = findByIdForUpdate.get();
			updatableAccount.setAccountStatus(AccountConstants.ACCOUNT_STATUS_INACTIVE);
			accountRepository.save(updatableAccount);
			accountRepository.flush();
		}
		
		Optional<Account> findByIdAfterUpdate = accountRepository.findById(accountUpdateTestData.getAccountNumber());
		
		if(findByIdAfterUpdate.isPresent()) {
			Account updatedAccountInfo = findByIdAfterUpdate.get();
			assertThat(updatedAccountInfo.getAccountStatus()).isNotEqualTo(accountUpdateTestData.getAccountStatus());
		}
	}
	
	@Test
	public void fetchAllAccountByIFSCTest() {
		
		accountRepository.save(accountUpdateTestData);
		accountRepository.save(accountCreateTestData);
		accountRepository.save(accountDeleteTestData);
		accountRepository.save(accountReadTestData);
		accountRepository.save(differentIFSCTestData);
		accountRepository.flush();

		List<Account> findAllByIFSC = accountRepository.findByIFSC(AccountConstants.ACCOUNT_IFSC);
		
		if(!findAllByIFSC.isEmpty()) {
			assertThat(4).isEqualTo(findAllByIFSC.size());
		}
	}
	
	@Test
	public void fetchAccountByNumberTest() {
		
		accountRepository.save(accountUpdateTestData);
		accountRepository.save(accountCreateTestData);
		accountRepository.save(accountDeleteTestData);
		accountRepository.save(accountReadTestData);
		accountRepository.save(differentIFSCTestData);
		accountRepository.flush();
		
		Account findByAccountNumber = accountRepository.findByAccountNumber(accountReadTestData.getAccountNumber());
		
		if(findByAccountNumber != null) {
			assertThat(findByAccountNumber).isEqualToComparingFieldByField(accountReadTestData);
		}
		
		
	}
	
	@Test
	public void addFundsToAccountTest() {
		
		accountRepository.save(accountUpdateTestData);
		accountRepository.save(accountCreateTestData);
		accountRepository.save(accountDeleteTestData);
		accountRepository.save(accountReadTestData);
		accountRepository.save(differentIFSCTestData);
		accountRepository.flush();
		
		AddFundsToAccountRequestObject accountRequestObject = new AddFundsToAccountRequestObject();
		accountRequestObject.setAccountNumber(accountReadTestData.getAccountNumber());
		
		accountRequestObject.setAmmountToAdd(new BigDecimal(5000.00));
		
		Optional<Account> findById = accountRepository.findById(accountRequestObject.getAccountNumber());
		
		assertThat(findById).isNotEmpty();
		
		Account fetchedForUpdate = findById.get();
		
		//System.out.println(" Before Update: " + fetchedForUpdate.getAccountBalanceAmount());
		
		BigDecimal currentBalance = fetchedForUpdate.getAccountBalanceAmount();
		
		BigDecimal modifiedBalance = currentBalance.add(accountRequestObject.getAmmountToAdd());
		
		fetchedForUpdate.setAccountBalanceAmount(modifiedBalance);
		
		Account saved = accountRepository.save(fetchedForUpdate);
		
		//System.out.println("After update: " + saved.getAccountBalanceAmount());
	}
	
	@Test
	public void test() {
		
		BigDecimal bigDecimal = new BigDecimal(5000.60);
		System.out.println("Original: " + bigDecimal);
		BigDecimal added = bigDecimal.add(new BigDecimal(1000.00));
		System.out.println("After Modification: " + bigDecimal);
		System.out.println("Other Big: " + added);
	}
}
