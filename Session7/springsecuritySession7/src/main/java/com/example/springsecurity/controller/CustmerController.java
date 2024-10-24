package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Customer;
import com.example.springsecurity.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CustmerController {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> saveRegistration(@RequestBody Customer customer) {
        try {
            customer.setPwd(passwordEncoder.encode(customer.getPwd()));
            customerRepository.save(customer);
            return ResponseEntity.ok("Registration Successful");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }
}
