package com.example.springsecurity.serviceImpl;

import com.example.springsecurity.repository.CardsRepository;
import com.example.springsecurity.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardsRepository cardsRepository;

}
