package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactUsController {
    @GetMapping("/contactus")
    public String contactUs() {
        return "Contact Us";
    }
}
