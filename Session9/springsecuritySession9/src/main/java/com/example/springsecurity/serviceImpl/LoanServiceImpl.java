package com.example.springsecurity.serviceImpl;

import com.example.springsecurity.repository.LoanRepository;
import com.example.springsecurity.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;
}
