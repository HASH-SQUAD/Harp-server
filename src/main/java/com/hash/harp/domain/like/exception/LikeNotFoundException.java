package com.hash.harp.domain.like.exception;

import com.hash.harp.global.exception.HarpException;
import org.springframework.http.HttpStatus;

public class LikeNotFoundException extends HarpException {
    public LikeNotFoundException() {
        super(HttpStatus.NOT_FOUND, "좋아요를 찾을 수 없습니다.");
    }
}
