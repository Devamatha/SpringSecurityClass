package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {

    @GetMapping("/getLoans")
    public String getLoans() {
        return "Here are the loans details from the database.";
    }
}
