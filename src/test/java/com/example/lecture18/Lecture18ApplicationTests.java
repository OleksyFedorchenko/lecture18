package com.example.lecture18;

import com.example.lecture18.documents.Message;
import com.example.lecture18.service.MailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.bson.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Lecture18ApplicationTests {

    @Autowired
    private MailSenderService emailService;

    @Test
    public void sendEmail_ShouldSendEmail_WhenGivenValidMessage() {
        // Create a new message object with valid email address, subject, and content
        Message message = new Message();
        message.setEmail("otihiy@gmail.com");
        message.setContent("CONTENT");
        message.setSubject("SUBJECT");

        // Call the sendEmail method and assert that it returns "Mail is sent!"
        String result = emailService.sendEmail(message);
        assertEquals("Mail is sended!", result);
    }

    @Test
    public void sendEmail_ShouldReturnErrorMessage_WhenEncountersError() {
        // Create a new message object with an invalid email address
        Message message = new Message();
        message.setEmail("invalid-email-address");
        message.setContent("CONTENT");
        message.setSubject("SUBJECT");

        // Call the sendEmail method and assert that it returns an error message
        String result = emailService.sendEmail(message);
        assertNotNull(result);
        assertTrue(result.contains("Invalid Addresses"));
    }
}
