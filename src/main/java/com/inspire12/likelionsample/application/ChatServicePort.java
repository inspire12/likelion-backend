package com.inspire12.likelionsample.application;

import com.inspire12.likelionsample.domain.websocket.ChatMessage;

public interface ChatServicePort {
    ChatMessage sendMessage(ChatMessage message);
}
