package org.example.repo;

import org.example.model.ChatMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatMessageRepo extends MongoRepository<ChatMessage, String> {
}
