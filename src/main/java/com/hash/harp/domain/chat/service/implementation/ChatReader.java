package com.hash.harp.domain.chat.service.implementation;

import com.hash.harp.domain.chat.controller.dto.response.ChatResponse;
import com.hash.harp.domain.chat.domain.Chat;
import com.hash.harp.domain.chat.repository.ChatRepository;
import com.hash.harp.domain.post.controller.dto.PostListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatReader {

    private final ChatRepository chatRepository;

    public List<ChatResponse> readAll() {
        return chatRepository.findAll().stream()
                .map(ChatResponse::of)
                .toList();
    }
}
