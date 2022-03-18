package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {

    @Autowired
    private EmailService emailService;

    @PostMapping("/sendemail")
    public Map<String, String> sendEmail() {

        String from = "FROM EMAIL";
        String to = "TO EMAIL";
        String body = "I am a test message sent from [Master-Data]";

        try {

            emailService.sendSimpleMessage(from, to, body);
            return Map.of("Message", "Success");

        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("Message", "Failed");
        }

    }

    @GetMapping("/")
    public Map<String, String> index() {
        return Map.of("Message", "Running on localhost....");
    }
}
