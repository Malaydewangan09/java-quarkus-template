package com.asyncapi;

import com.asyncapi.model.Message;
import com.asyncapi.service.MessageService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@QuarkusTest
public class MessageServiceTest {

    @Inject
    MessageService messageService;

    @Test
    public void testProcessMessage() {
        Message message = new Message();
        message.setPayload("Test message");
        assertDoesNotThrow(() -> messageService.processMessage(message));
    }
} 