package com.example.springsecurity.service;

import com.example.springsecurity.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer saveCustomer(Customer customer);

    public Customer getCustomer(Long customerId);

    public Customer updateCustomer(Customer customer, Long customerId);

    public void deleteCustomer(Long customerId);

    public List<Customer> getAllCustomers();
}
