package com.hash.harp.domain.chat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hash.harp.domain.chat.controller.dto.request.chat.ChatRequest;
import com.hash.harp.domain.chat.controller.dto.response.chat.AnswerResponse;
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

    public Object proccessChat(ChatRequest chatRequest, Long userId, Long chatId, String endpoint) throws JsonProcessingException {
        Type type = typeEndpoint(endpoint);

        return chatCreator.processChat(chatRequest, userId, chatId, String.valueOf(type));
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
