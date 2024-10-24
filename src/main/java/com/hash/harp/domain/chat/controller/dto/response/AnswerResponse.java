package com.hash.harp.domain.chat.controller.dto.response;

import java.util.List;

public record AnswerResponse(
        String role,

        List<Content> contents
) {
}
