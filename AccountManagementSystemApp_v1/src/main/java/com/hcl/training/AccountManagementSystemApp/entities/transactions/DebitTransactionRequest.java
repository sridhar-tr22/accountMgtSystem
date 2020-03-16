package com.hcl.training.AccountManagementSystemApp.entities.transactions;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.hcl.training.AccountManagementSystemApp.entities.RequestObjects;

/**
 * @author User1
 * 
 * <p> the {@link DebitTransactionRequest} is used for carrying transaction requests. </p>
 *
 */
public class DebitTransactionRequest implements RequestObjects {
	
	private String referenceId;
	private String transactionType;
	private LocalDateTime transactionDate;
	private String fromAccountNumber;
	private String beneficiaryAccountNumber;
	private BigDecimal transactionAmount;

	public DebitTransactionRequest() {}

	public String getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(String referenceId) {
		this.referenceId = referenceId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getBeneficiaryAccountNumber() {
		return beneficiaryAccountNumber;
	}

	public void setBeneficiaryAccountNumber(String beneficiaryAccountNumber) {
		this.beneficiaryAccountNumber = beneficiaryAccountNumber;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
}
