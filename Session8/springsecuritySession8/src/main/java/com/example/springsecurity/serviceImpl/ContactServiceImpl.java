package com.example.springsecurity.serviceImpl;

import com.example.springsecurity.repository.ContactRepository;
import com.example.springsecurity.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

}
