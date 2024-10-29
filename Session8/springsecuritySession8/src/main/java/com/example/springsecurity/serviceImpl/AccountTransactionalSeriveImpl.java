package com.example.springsecurity.serviceImpl;

import com.example.springsecurity.repository.AccountTransactionsRepository;
import com.example.springsecurity.repository.AccountsRepository;
import com.example.springsecurity.repository.CustomerRepository;
import com.example.springsecurity.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountTransactionalSeriveImpl implements AccountService {
    @Autowired
    private AccountTransactionsRepository accountTransactionsRepository;
    @Autowired
    private AccountsRepository accountsRepository;
    @Autowired
    private CustomerRepository customerRepository;
}
