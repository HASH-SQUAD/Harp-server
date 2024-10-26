package com.hash.harp.domain.chat.controller.dto.request.chat;

import java.util.List;

public record ChatRequest(
        String role,
        List<Content> content
) {}