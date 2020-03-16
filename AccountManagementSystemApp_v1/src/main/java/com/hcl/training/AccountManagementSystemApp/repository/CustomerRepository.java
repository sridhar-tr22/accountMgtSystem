package com.hcl.training.AccountManagementSystemApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.training.AccountManagementSystemApp.entities.cutomers.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, String>, CustomizedCustomerRepository {}
