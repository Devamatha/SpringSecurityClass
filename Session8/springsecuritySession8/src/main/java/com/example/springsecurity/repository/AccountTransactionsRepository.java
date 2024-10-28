package com.example.springsecurity.repository;

import com.example.springsecurity.entity.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionsRepository extends JpaRepository<AccountTransaction, String> {
}
