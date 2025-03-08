package com.inspire12.likelionsample.adapter.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.inspire12.likelionsample.application.ChatServicePort;
import com.inspire12.likelionsample.domain.websocket.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.concurrent.CopyOnWriteArraySet;

@Service
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private final ChatServicePort chatService;
    private final ObjectMapper objectMapper;
    // 모든 활성 세션을 보관 (브로드캐스트 용도)
    private final CopyOnWriteArraySet<WebSocketSession> sessions = new CopyOnWriteArraySet<>();

    @Autowired
    public ChatWebSocketHandler(ChatServicePort chatService, ObjectMapper objectMapper) {
        this.chatService = chatService;
        this.objectMapper = objectMapper;
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // JSON 형식의 문자열을 ChatMessage 객체로 역직렬화
        ChatMessage chatMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
        // 도메인 서비스 로직 실행 (예: 검증, 로깅)
        ChatMessage processedMessage = chatService.sendMessage(chatMessage);
        // 처리 결과를 다시 JSON으로 직렬화하여 모든 클라이언트에 브로드캐스트
        String broadcastMessage = objectMapper.writeValueAsString(processedMessage);
        for (WebSocketSession s : sessions) {
            s.sendMessage(new TextMessage(broadcastMessage));
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        sessions.remove(session);
    }
}