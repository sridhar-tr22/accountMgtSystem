package com.hcl.training.AccountManagementSystemApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.training.AccountManagementSystemApp.entities.transactions.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {}
