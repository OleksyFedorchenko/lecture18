package com.example.lecture18.documents;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document
public class Message {
    private String id;
    private String subject;
    private String content;
    private String email;
    private boolean send;
    private String errorMessage;
}
