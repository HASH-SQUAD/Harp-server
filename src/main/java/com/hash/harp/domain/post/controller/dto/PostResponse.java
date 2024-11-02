package com.hash.harp.domain.post.controller.dto;

import com.hash.harp.domain.post.domain.Post;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String title,
        String content,
        String imgUrl,
        Integer commentCount,
        LocalDateTime createTime,
        Long writer,
        String category
) {
    public static PostResponse of(Post post) {
        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getImgUrl(),
                Math.toIntExact(post.getCommentCount()),
                post.getCreateTime(),
                post.getWriter(),
                post.getCategory()
        );
    }
}
