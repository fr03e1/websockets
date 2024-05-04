package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.model.ChatMessage;
import org.example.model.MessageStatus;
import org.example.repo.ChatMessageRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService{
    private final ChatMessageRepo chatMessageRepo;

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        chatMessage.setStatus(MessageStatus.RECEIVED);
        this.chatMessageRepo.save(chatMessage);
        return chatMessage;
    }
}
