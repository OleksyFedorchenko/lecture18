package com.example.lecture18.service;

import com.example.lecture18.documents.Message;
import com.example.lecture18.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class ConsumerService {
    MessageRepository messageRepository;
    MailSenderService mailSenderService;

    @Autowired
    public ConsumerService(MessageRepository messageRepository, MailSenderService mailSenderService) {
        this.messageRepository = messageRepository;
        this.mailSenderService = mailSenderService;
    }

    @KafkaListener(topics = "mail_topic", groupId = "group_id")
    public void consume(Message message) {
        System.out.println("Consuming the message: " + message);
        sendEmail(message);
        messageRepository.save(message);

    }

    public void sendEmail(Message message) {
        String eMessage = mailSenderService.sendEmail(message);
        if (eMessage.equals("Mail is sended!")) {
            System.out.println(eMessage);
            message.setSend(true);
            message.setErrorMessage("");
            messageRepository.save(message);
            System.out.println(messageRepository.findAll());
        } else {
            message.setSend(false);
            message.setErrorMessage(eMessage);
            messageRepository.save(message);
        }
    }
}
