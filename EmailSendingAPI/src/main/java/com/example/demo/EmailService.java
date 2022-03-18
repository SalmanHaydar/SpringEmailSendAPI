package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

    @Autowired
    private JavaMailSender emailsender;

    public void sendSimpleMessage(String from, String to, String msg) {

        try {

            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom(from);
            message.setTo(to);
            message.setSubject("[Master-Data] It's a test message!");
            message.setText(msg);

            emailsender.send(message);
        } catch (MailException exception) {

                exception.printStackTrace();
    }
    }
}
