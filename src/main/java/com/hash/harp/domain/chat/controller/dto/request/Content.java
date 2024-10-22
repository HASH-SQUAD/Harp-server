package com.hash.harp.domain.chat.controller.dto.request;

public record Content(
        String type,
        Object text
) {}