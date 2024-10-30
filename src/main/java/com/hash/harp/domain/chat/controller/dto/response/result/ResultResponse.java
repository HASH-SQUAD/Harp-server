package com.hash.harp.domain.chat.controller.dto.response.result;

import java.util.List;
import java.util.Map;

public record ResultResponse(
        String role,
        Map<String, List<Schedule>> day,
        List<String> tips
) {
}
