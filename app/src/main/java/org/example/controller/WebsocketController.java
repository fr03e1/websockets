package org.example.controller;

import org.example.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketController {

    @MessageMapping("/chat")
    public Message sendMessage(Message message) {
        System.out.println(message.getContent());
        return message;
    }
}
