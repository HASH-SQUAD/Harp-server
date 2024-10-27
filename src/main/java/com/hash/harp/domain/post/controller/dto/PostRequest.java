package com.hash.harp.domain.post.controller.dto;

import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.user.domain.User;
import jakarta.validation.constraints.NotNull;

public record PostRequest (
        @NotNull(message = "제목은 필수 값입니다.")
        String title,

        String content,

        String imgUrl
){
}
