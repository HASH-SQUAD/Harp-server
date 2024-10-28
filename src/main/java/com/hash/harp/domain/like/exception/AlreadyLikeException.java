package com.hash.harp.domain.like.exception;

import com.hash.harp.global.exception.HarpException;
import org.springframework.http.HttpStatus;

public class AlreadyLikeException extends HarpException {
    public AlreadyLikeException() {
        super(HttpStatus.BAD_REQUEST, "이미 좋아요를 눌렀습니다.");
    }
}
