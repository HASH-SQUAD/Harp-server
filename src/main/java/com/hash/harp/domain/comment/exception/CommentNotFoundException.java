package com.hash.harp.domain.comment.exception;

import com.hash.harp.global.exception.HarpException;
import org.springframework.http.HttpStatus;

public class CommentNotFoundException extends HarpException {
    public CommentNotFoundException() {
        super(HttpStatus.NOT_FOUND, "댓글을 찾을 수 없습니다.");
    }
}
