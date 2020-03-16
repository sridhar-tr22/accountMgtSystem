package com.hcl.training.AccountManagementSystemApp.entities.accounts;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hcl.training.AccountManagementSystemApp.entities.cutomers.Customer;

@Entity
@Table(name = "account")
public class Account {
	
	@Id
	private String accountNumber;
	private String IFSC;
	private String accountType;
	private String accountStatus;
	private BigDecimal accountBalanceAmount;
	
	
	 @ManyToOne 
	 private Customer customer;
	
	
	/**
	 * default constructor
	 */
	public Account() {}
	
	/**
	 * @param accountNumber
	 * @param iFSC
	 * @param accountType
	 * @param accountStatus
	 */
	public Account(String accountNumber, String iFSC, String accountType, String accountStatus) {
		super();
		this.accountNumber = accountNumber;
		IFSC = iFSC;
		this.accountType = accountType;
		this.accountStatus = accountStatus;
		this.accountBalanceAmount = new BigDecimal(0);
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getIFSC() {
		return IFSC;
	}


	public void setIFSC(String iFSC) {
		IFSC = iFSC;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Customer getCustomer() { 
		return customer; 
	}
	  
	public void setCustomer(Customer customer) { 
		this.customer = customer; 
	}
	
	public BigDecimal getAccountBalanceAmount() {
		return accountBalanceAmount;
	}

	public void setAccountBalanceAmount(BigDecimal accountBalanceAmount) {
		this.accountBalanceAmount = accountBalanceAmount;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(obj == null || getClass() != obj.getClass()) {
			return false;
		}
		
		Account otherAccount = (Account) obj;
		return Objects.equals(accountNumber, otherAccount.accountNumber);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(accountNumber);
	}
	
	@Override
	public String toString() {
		return accountNumber;
	}
}
