package com.example.springsecurity.controller;

import com.example.springsecurity.entity.Customer;
import com.example.springsecurity.repository.CustomerRepository;
import com.example.springsecurity.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustmerController {
    private final CustomerRepository customerRepository;
    private CustomerService customerService;

    @PostMapping("/register")
    public ResponseEntity<String> saveRegistration(@RequestBody Customer customer) {
        try {
            customerService.saveCustomer(customer);
            return ResponseEntity.ok("Registration Successful");
        } catch (Exception e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        try {
            customerService.updateCustomer(customer, customerId);
            return ResponseEntity.ok(customer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping("delete/{customerId}")
    public void delete(@PathVariable Long customerId) {
        try {

            customerService.deleteCustomer(customerId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/getall")
    public List<Customer> getAll() {
        List<Customer> customer = customerService.getAllCustomers();
        return customer;
    }

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Authentication authentication) {
        Optional<Customer> optionalCustomer = customerRepository.findByEmail(authentication.getName());
        return optionalCustomer.orElse(null);
    }
}
