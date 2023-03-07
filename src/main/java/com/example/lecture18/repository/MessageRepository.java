package com.example.lecture18.repository;

import com.example.lecture18.documents.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends MongoRepository<Message,String> {

List<Message> findBySend(boolean send);
}
