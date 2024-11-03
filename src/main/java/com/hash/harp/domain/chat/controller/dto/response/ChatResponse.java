package com.hash.harp.domain.chat.controller.dto.response;

import com.hash.harp.domain.chat.domain.Chat;

import java.time.LocalDateTime;

public record ChatResponse(
        Long id,
        LocalDateTime updateDateTime
) {
    public static ChatResponse of(Chat chat) {
        return new ChatResponse(
                chat.getId(),
                chat.getUpdateDateTime()
        );
    }
}
