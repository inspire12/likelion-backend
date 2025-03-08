package com.inspire12.likelionsample.infrasturcture.service;

import com.inspire12.likelionsample.application.ChatServicePort;
import com.inspire12.likelionsample.domain.websocket.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatServicePort  {
    private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);


    @Override
    public ChatMessage sendMessage(ChatMessage message) {
        logger.info("Received message from {}: {}", message.sender(), message.content());
        return message;
    }
}
