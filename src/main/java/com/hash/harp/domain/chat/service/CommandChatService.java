package com.hash.harp.domain.chat.service;

import com.hash.harp.domain.chat.controller.dto.request.ChatRequest;
import com.hash.harp.domain.chat.domain.type.Type;
import com.hash.harp.domain.chat.exception.ChatCreationFailedException;
import com.hash.harp.domain.chat.service.implementation.ChatCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandChatService {

    private final ChatCreator chatCreator;

    public void createChat(String userJson, Long userId, String endpoint) {
        Type type = typeEndpoint(endpoint);
        chatCreator.createChat(userJson, userId, String.valueOf(type));
    }

    private Type typeEndpoint(String endpoint) {
        if ("/travel".equals(endpoint)) {
            return Type.TRAVEL;
        } else if ("/date".equals(endpoint)) {
            return Type.DATE;
        } else {
            throw new ChatCreationFailedException("유효하지 않은 엔드포인트입니다.");
        }
    }
}
