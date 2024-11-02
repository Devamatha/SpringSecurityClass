package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Accounts, Integer> {
}
