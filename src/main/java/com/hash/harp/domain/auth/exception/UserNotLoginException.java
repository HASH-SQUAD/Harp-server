package com.hash.harp.domain.auth.exception;

import com.hash.harp.global.exception.HarpException;

import static org.springframework.http.HttpStatus.*;

public class UserNotLoginException extends HarpException {
    public UserNotLoginException() {
        super(FORBIDDEN, "유저가 로그인하지 않았습니다.");
    }
}
