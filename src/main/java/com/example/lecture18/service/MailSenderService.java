package com.example.lecture18.service;

import com.example.lecture18.documents.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService{
    private final MailSenderServiceProps mailSender;

    @Autowired
    public MailSenderService(MailSenderServiceProps mailSender) {
        this.mailSender = mailSender;
    }

    public String sendEmail(Message message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setFrom("otihiy@gmail.com");
        mail.setTo(message.getEmail());
        mail.setText(message.getContent());
        mail.setSubject(message.getSubject());

        try {
            mailSender.getJavaMailSender().send(mail);
            return "Mail is sended!";
        } catch (MailException m) {
            System.out.println(m.getMessage());
            return m.getMessage();
        }
    }

}
