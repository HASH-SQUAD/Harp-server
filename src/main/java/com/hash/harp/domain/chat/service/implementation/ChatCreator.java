package com.hash.harp.domain.chat.service.implementation;

import com.hash.harp.domain.chat.controller.dto.request.ChatRequest;
import com.hash.harp.domain.chat.domain.Chat;
import com.hash.harp.domain.chat.domain.type.Type;
import com.hash.harp.domain.chat.exception.ChatCreationFailedException;
import com.hash.harp.domain.chat.repository.ChatRepository;
import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.exception.UserNotFoundException;
import com.hash.harp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatCreator {

    private final ChatRepository chatRepository;

    private final UserRepository userRepository;

    public Chat createChat(String userJson, Long userId, String type){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Chat chat = Chat.builder()
                .userId(user.getId())
                .chat(userJson)
                .type(Type.valueOf(type))
                .updateDateTime(LocalDateTime.now())
                .build();

        return chatRepository.save(chat);
    }
}
