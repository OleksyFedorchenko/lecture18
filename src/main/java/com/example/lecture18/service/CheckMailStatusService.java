package com.example.lecture18.service;

import com.example.lecture18.documents.Message;
import com.example.lecture18.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckMailStatusService {

    MessageRepository messageRepository;
    MailSenderService mailSenderService;

    @Autowired
    public CheckMailStatusService(MessageRepository messageRepository, MailSenderService mailSenderService) {
        this.messageRepository = messageRepository;
        this.mailSenderService = mailSenderService;
    }

    @Scheduled(initialDelay = 1000L, fixedDelay = 300000L)
    void method() {
        List<Message> messages = messageRepository.findBySend(false);
        System.out.println(messages);
        for (Message m : messages
        ) {
            String eMessage = mailSenderService.sendEmail(m);
            if (eMessage.equals("Mail is sended!")) {
                System.out.println(eMessage);
                m.setSend(true);
                m.setErrorMessage("");
            } else {
                m.setSend(false);
                m.setErrorMessage(eMessage);
            }
        }
        if (!messages.isEmpty()) {
            messageRepository.saveAll(messages);
        }
    }
}
