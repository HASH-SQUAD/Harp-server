package com.hash.harp.domain.chat.controller.dto.response.chat;

import java.util.List;

public record Text(
        String subject,

        String category,

        String question,

        List<String> select
) {
}