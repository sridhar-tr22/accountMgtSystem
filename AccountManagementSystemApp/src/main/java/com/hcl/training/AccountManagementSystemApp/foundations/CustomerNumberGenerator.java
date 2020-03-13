package com.hcl.training.AccountManagementSystemApp.foundations;

import java.util.concurrent.atomic.AtomicLong;

public class CustomerNumberGenerator {

	public static AtomicLong customerNumberSequence = new AtomicLong(1000);
	
	public static String generateAccountNumber() {
		
		long incrementAndGet = customerNumberSequence.incrementAndGet();
		StringBuilder value = new StringBuilder();
		value.append(incrementAndGet);
		return value.toString();
	}
}
