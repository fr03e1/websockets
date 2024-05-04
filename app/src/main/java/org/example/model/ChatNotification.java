package org.example.model;

import lombok.Builder;

@Builder
public class ChatNotification {
    private String id;
    private String senderId;
    private String senderName;
}
