package com.hash.harp.domain.post.controller.dto;

import com.hash.harp.domain.post.domain.Post;

import java.time.LocalDateTime;

public record PostListResponse(
        Long id,
        String title,
        Long writer,
        LocalDateTime createTime
) {
    public static PostListResponse of(Post post) {
        return new PostListResponse(
                post.getId(),
                post.getTitle(),
                post.getWriter(),
                post.getCreateTime());
    }
}
