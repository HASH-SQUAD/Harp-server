package com.hash.harp.domain.chat.exception;

import com.hash.harp.global.exception.HarpException;
import org.springframework.http.HttpStatus;

public class ChatCreationFailedException extends HarpException {
    public ChatCreationFailedException(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, message);
    }
}