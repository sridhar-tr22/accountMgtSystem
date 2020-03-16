package com.hcl.training.AccountManagementSystemApp.controllers;


import java.time.chrono.IsoChronology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.training.AccountManagementSystemApp.controllers.models.request.CustomerRequestVO;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.CustomerPersonalDetailsReqObj;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.CustomersAccountDetailsReqObj;
import com.hcl.training.AccountManagementSystemApp.entities.utils.AccountConstants;
import com.hcl.training.AccountManagementSystemApp.services.customers.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@RequestMapping(path = "/create-account", method = RequestMethod.POST)
	public void createCustomer(@RequestBody CustomerRequestVO customerRequestVO) {
		try {
				CustomersAccountDetailsReqObj accountRequest = new CustomersAccountDetailsReqObj();
				accountRequest.setAccountType(customerRequestVO.getAccountType());
				accountRequest.setIFSC(customerRequestVO.getIFSC());
				
				CustomerPersonalDetailsReqObj request = new CustomerPersonalDetailsReqObj();
				request.setName(customerRequestVO.getName());
				request.setAddress(customerRequestVO.getAddress());
				request.setBirthDay(customerRequestVO.getBirthDay());
				request.setEmail(customerRequestVO.getEmail());
				request.setPhone(customerRequestVO.getPhone());
				
				request.setAccountDetailsReqObj(accountRequest);
				customerServiceImpl.createCustomerAndAssociateAccount(request);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	  @RequestMapping(path = "/get", method = RequestMethod.GET) public
	  CustomerRequestVO getCustomer() { CustomerRequestVO requestVO = new
	  CustomerRequestVO();
	  requestVO.setAccountType(AccountConstants.ACCOUNT_TYPE_SAVING);
	  requestVO.setIFSC(AccountConstants.ACCOUNT_IFSC);
	  requestVO.setName("Name Of Customer");
	  requestVO.setAddress("35, Church Street, Bengaluru");
	  requestVO.setBirthDay(IsoChronology.INSTANCE.date(2000, 1, 15));
	  requestVO.setEmail("email@sample.com"); requestVO.setPhone("9876222111");
	  return requestVO; }
	 
	
}
