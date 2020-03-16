package com.hcl.training.AccountManagementSystemApp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.training.AccountManagementSystemApp.controllers.models.request.FundTransferRequest;
import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;
import com.hcl.training.AccountManagementSystemApp.services.AccountService;


@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService; 
	
	@PostMapping(path = "/create")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createdAccount = accountService.createAccount(account);
		//Account createdAccount = new Account(50005L, AccountConstants.ACCOUNT_IFSC, AccountConstants.ACCOUNT_TYPE_SAVING , AccountConstants.ACCOUNT_STATUS_ACTIVE);
		return new ResponseEntity<Account>(createdAccount, HttpStatus.CREATED);
	}
	
	@PostMapping(path = "/get")
	public ResponseEntity<Account> fetchAccountByNumber(@RequestBody Account account) {
		String accountNumber = account.getAccountNumber();
		Account fetchedAccountByNumber = accountService.fetchAccountByNumber(accountNumber);
		return new ResponseEntity<Account>(fetchedAccountByNumber,HttpStatus.FOUND) ;
	}
	
	@PutMapping(path = "/update")
	public ResponseEntity<Account> updateAccountStatus(@RequestBody Account account) {
		Account updatedAccountStatus = accountService.updateAccountStatus(account);
		return new ResponseEntity<Account>(updatedAccountStatus, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/IFSC/{IFSC}")
	public ResponseEntity<List<Account>> fetchAccountByNumber(@PathVariable(name = "IFSC")String IFSC) {
		 List<Account> fetchedAllAccountsByIFSC = accountService.fetchAllAccountsByIFSC(IFSC);
		return new ResponseEntity<List<Account>>(fetchedAllAccountsByIFSC, HttpStatus.FOUND);
	}
	
	@PostMapping(path = "/transferFunds")
	public void transferFund(@RequestBody FundTransferRequest fundTransferRequest) {
		
	}
	
	
}
