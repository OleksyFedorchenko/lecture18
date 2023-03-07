package com.example.lecture18.controller;

import com.example.lecture18.documents.Message;
import com.example.lecture18.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    private final ProducerService producerService;

    @Autowired
    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/mailprops")
    public String generate(@RequestBody Message message) {
        producerService.produce(message);
        return "OK";
    }
}
