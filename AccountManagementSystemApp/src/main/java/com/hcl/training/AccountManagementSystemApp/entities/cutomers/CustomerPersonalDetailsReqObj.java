package com.hcl.training.AccountManagementSystemApp.entities.cutomers;

import java.time.LocalDate;

import com.hcl.training.AccountManagementSystemApp.entities.RequestObjects;

public class CustomerPersonalDetailsReqObj implements RequestObjects {

	private String name;
	private String address;
	private String phone;
	private String email;
	private LocalDate birthDay;
	private boolean isEligible;
	
	private CustomersAccountDetailsReqObj accountDetailsReqObj;
	
	public CustomerPersonalDetailsReqObj() {}
	
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
	public boolean getEligiblity() {
		return isEligible;
	}
	public void setEligible(boolean isEligible) {
		this.isEligible = isEligible;
	}

	public CustomersAccountDetailsReqObj getAccountDetailsReqObj() {
		return accountDetailsReqObj;
	}

	public void setAccountDetailsReqObj(CustomersAccountDetailsReqObj accountDetailsReqObj) {
		this.accountDetailsReqObj = accountDetailsReqObj;
	}
}
