package com.hash.harp.domain.comment.exception;

import com.hash.harp.global.exception.HarpException;
import org.springframework.http.HttpStatus;

public class CommentNotAuthorException extends HarpException {
    public CommentNotAuthorException() {
      super(HttpStatus.FORBIDDEN, "댓글 작성자가 아닙니다.");
    }
}
