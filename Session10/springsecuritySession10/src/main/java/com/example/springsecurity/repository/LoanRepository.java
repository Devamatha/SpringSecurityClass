package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Loans;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loans, Long> {
}
