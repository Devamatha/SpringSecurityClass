package com.example.springsecurity.repository;

import com.example.springsecurity.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransaction, String> {
    List<AccountTransaction> findByCustomerIdOrderByTransactionDtDesc(long customerId);

}
