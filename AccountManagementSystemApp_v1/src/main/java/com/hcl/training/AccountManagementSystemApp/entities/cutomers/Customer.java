package com.hcl.training.AccountManagementSystemApp.entities.cutomers;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.hcl.training.AccountManagementSystemApp.entities.accounts.Account;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	private String customerId;
	private String name;
	private String address;
	private String phone;
	private String email;
	private LocalDate birthDay;
	private boolean isEligible;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, targetEntity = Account.class)
	private List<Account> accounts = new ArrayList<>();
	 
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}
	public boolean isEligible() {
		return isEligible;
	}
	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}
	
	public int getAge() {
		return this.birthDay.until
				(IsoChronology.INSTANCE.dateNow())
				.getYears();
	}
	
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	
	/**
	 * @param account'
	 *
	 * links an Account with the customer instance
	 */
	public void linksAnAccountWithThisCustomer(Account account) {
		accounts.add(account);
		account.setCustomer(this);
	}
	
	/**
	 * @param account
	 * 
	 *  removes an linked account from the customer
	 */
	public void removeAnAccountAssociatedWithThisCustomer(Account account) {
		accounts.remove(account);
		account.setCustomer(null);
	}
	
}