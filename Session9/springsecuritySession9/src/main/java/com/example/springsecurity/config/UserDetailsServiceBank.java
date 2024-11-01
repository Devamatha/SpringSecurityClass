package com.example.springsecurity.config;

import com.example.springsecurity.entity.Customer;
import com.example.springsecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsServiceBank implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customers = customerRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
//        List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority(customers.getRole()));

        List<GrantedAuthority> authorities = customer.getAuthorities().stream().map(authority -> new
                SimpleGrantedAuthority(authority.getName())).collect(Collectors.toList());
        return new User(customers.getEmail(), customers.getPwd(), authorities);
    }
}
