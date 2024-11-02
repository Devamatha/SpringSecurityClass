package com.example.springsecurity.serviceImpl;

import com.example.springsecurity.repository.NoticeRepository;
import com.example.springsecurity.service.NoticesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticesServiceImpl implements NoticesService {

    @Autowired
    private NoticeRepository noticesRepository;
}
