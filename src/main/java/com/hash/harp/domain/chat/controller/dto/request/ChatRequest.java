package com.hash.harp.domain.chat.controller.dto.request;

import java.util.List;

public record ChatRequest(
        String role,
        List<Content> content
) {}