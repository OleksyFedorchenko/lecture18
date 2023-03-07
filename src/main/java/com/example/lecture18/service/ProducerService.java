package com.example.lecture18.service;

import com.example.lecture18.documents.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void produce(Message message) {
        System.out.println("Producing the message: " + message);
        kafkaTemplate.send("mail_topic", message);
    }
}
