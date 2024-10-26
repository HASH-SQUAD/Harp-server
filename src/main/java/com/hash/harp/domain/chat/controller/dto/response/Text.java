package com.hash.harp.domain.chat.controller.dto.response;

import java.util.List;
import java.util.Map;

public record Text(
        String subject,

        String category,

        String question,

        List<String> select
) {
}