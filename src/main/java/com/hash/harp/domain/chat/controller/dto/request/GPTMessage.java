package com.hash.harp.domain.chat.controller.dto.request;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GPTMessage {

    private String role;

    private String content;

    @Builder
    public GPTMessage(String role, String content) {
        this.role = role;
        this.content = content;
    }
}
