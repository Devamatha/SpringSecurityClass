package com.example.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/getNotices")
    public String getNotices() {
        return "Here are the notices details from the database";
    }
}
