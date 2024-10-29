package com.hash.harp.domain.comment.controlle.dto;

import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.user.controller.dto.UserResponseDto;
import org.springframework.security.core.userdetails.User;

import java.time.LocalDateTime;
import java.util.List;

public record CommentResponse(
        Long id,
        String content,
        LocalDateTime createdAt,
        UserResponseDto userResponse,
        List<CommentResponse> children
) {
    public static CommentResponse of(Comment comment, com.hash.harp.domain.user.domain.User user) {
        return new CommentResponse(
                comment.getId(),
                comment.getContent(),
                comment.getCreatedAt(),
                UserResponseDto.from(user),
                comment.getChildren().stream()
                        .map(child -> CommentResponse.of(child, child.getWriter()))
                        .toList()
        );
    }
}