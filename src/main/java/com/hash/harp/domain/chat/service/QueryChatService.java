package com.hash.harp.domain.chat.service;

import com.hash.harp.domain.chat.controller.dto.response.ChatResponse;
import com.hash.harp.domain.chat.service.implementation.ChatReader;
import com.hash.harp.domain.post.controller.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryChatService {

    private final ChatReader chatReader;

    public List<ChatResponse> readAllChat() {
        return chatReader.readAll();
    }
}
