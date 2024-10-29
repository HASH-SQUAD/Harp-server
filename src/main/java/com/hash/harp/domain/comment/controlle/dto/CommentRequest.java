package com.hash.harp.domain.comment.controlle.dto;

import com.hash.harp.domain.comment.domain.Comment;
import jakarta.validation.constraints.NotNull;

public record CommentRequest(
        @NotNull String content,
        Long parent
) {
    public Comment toEntity() {
    return new Comment(content);}
}
