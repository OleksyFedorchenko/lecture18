package com.example.lecture18;

import com.example.lecture18.documents.Message;
import com.example.lecture18.service.MailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class Lecture18ApplicationTests {

    @MockBean
    MailSenderService mailSenderService;

    Message message = new Message();

    @Test
    public void sendEmailReturnString() {
        message.setEmail("otihiy@gmail.com");
        when(mailSenderService.sendEmail(message)).thenReturn("Mail Sended!");
        assertEquals("Mail Sended!", mailSenderService.sendEmail(message));
    }

    @Test
    public void wrongEmailThrowException() throws RuntimeException {
        message.setEmail("invalid-mail-address");
        when(mailSenderService.sendEmail(message)).thenThrow(RuntimeException.class);
        assertThrows(RuntimeException.class, () -> mailSenderService.sendEmail(message));
    }
}
