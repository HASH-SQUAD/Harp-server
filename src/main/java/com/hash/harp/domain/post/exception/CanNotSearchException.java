package com.hash.harp.domain.post.exception;

import com.hash.harp.global.exception.HarpException;
import org.springframework.http.HttpStatus;

public class CanNotSearchException extends HarpException {
    public CanNotSearchException() {
        super(HttpStatus.NOT_FOUND, "검색된 결과가 없습니다.");
    }
}
