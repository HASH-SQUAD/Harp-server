package com.hash.harp.domain.comment.controlle.dto;

import com.hash.harp.domain.comment.domain.Comment;

public record CommentRequest(
        String content,
        Long parent
) {
    public Comment toEntity() {
        return new Comment(content);
    }
}

