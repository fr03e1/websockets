package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.ChatMessage;
import org.example.model.ChatNotification;
import org.example.service.ChatMessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final ChatMessageService chatMessageService;
    private final SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/chat")
    public void sendMessage(@Payload ChatMessage message) {
        ChatMessage savedMessage = this.chatMessageService.save(message);
        this.simpMessagingTemplate.convertAndSendToUser(
                message.getRecipientId(),
                "/queue/messages",
                ChatNotification
                        .builder()
                        .id(savedMessage.getId())
                        .senderName(savedMessage.getSenderName())
                        .senderId(savedMessage.getSenderId())
                        .build()
        );
    }
}
