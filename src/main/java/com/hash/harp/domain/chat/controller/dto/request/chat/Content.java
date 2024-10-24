package com.hash.harp.domain.chat.controller.dto.request.chat;

public record Content(
        String type,
        Object text
) {}