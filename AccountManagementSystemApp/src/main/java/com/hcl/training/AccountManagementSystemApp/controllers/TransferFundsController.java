package com.hcl.training.AccountManagementSystemApp.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.training.AccountManagementSystemApp.controllers.models.request.FundTransferRequest;

@RestController
@RequestMapping("/transfer")
public class TransferFundsController {

	@RequestMapping(path = "/send", method = RequestMethod.POST)
	public void sendFund(FundTransferRequest  transferFundRequest) {
		
		
	}
	
	
}
