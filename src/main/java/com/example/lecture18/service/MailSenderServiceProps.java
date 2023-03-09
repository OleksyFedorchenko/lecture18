package com.example.lecture18.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;


@Service
public class MailSenderServiceProps {

    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(System.getenv("spring.mail.host"));
        mailSender.setPort(Integer.parseInt(System.getenv("spring.mail.port")));

        mailSender.setUsername(System.getenv("spring.mail.username"));
        mailSender.setPassword(System.getenv("spring.mail.password"));

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", System.getenv("spring.mail.properties.mail.smtp.auth"));
        props.put("mail.smtp.starttls.enable", System.getenv("spring.mail.properties.mail.smtp.starttls.enable"));
        props.put("mail.debug", "false");

        return mailSender;
    }
}
