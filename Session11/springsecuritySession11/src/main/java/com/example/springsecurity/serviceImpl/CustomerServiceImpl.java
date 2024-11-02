package com.example.springsecurity.serviceImpl;

import com.example.springsecurity.entity.Customer;
import com.example.springsecurity.repository.CustomerRepository;
import com.example.springsecurity.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final PasswordEncoder passwordEncoder;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setPwd(passwordEncoder.encode(customer.getPwd()));
        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomer(Long customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("customer Id is not found" + customerId));
    }

    @Override
    public Customer updateCustomer(Customer customer, Long customerId) {
        try {
            Customer customer_Id = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("customer Id is not found" + customerId));
            if (customer_Id.getRole() != null) {
                customer_Id.setRole(customer_Id.getRole());

            }
            if (customer_Id.getPwd() != null) {
                customer_Id.setPwd(customer_Id.getPwd());

            }
            if (customer_Id.getEmail() != null) {
                customer_Id.setEmail(customer_Id.getEmail());
            }
            if (customer_Id.getName() != null) {
                customer_Id.setName(customer_Id.getName());
            }
            return customerRepository.save(customer_Id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}