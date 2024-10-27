package com.hash.harp.domain.post.exception;

import com.hash.harp.global.exception.HarpException;
import org.springframework.http.HttpStatus;

public class PostNotFoundException extends HarpException {
    public PostNotFoundException(Long id) {
        super(HttpStatus.NOT_FOUND, "id가 " + id + "인 게시글을 찾을 수 없습니다.");
    }
}