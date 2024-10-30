package com.hash.harp.domain.plan.controller.dto.response;

public record HeaderCreateResponse(
        String message,
        Long headerId
) {
    public static HeaderCreateResponse from(String message, Long headerId) {
        return new HeaderCreateResponse(message, headerId);
    }
}
