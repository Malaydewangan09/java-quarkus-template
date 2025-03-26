package com.asyncapi.service;

import com.asyncapi.model.Message;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageService {
    
    public void processMessage(Message message) {
        // Process the message
        System.out.println("Processing message: " + message.getPayload());
    }
} 