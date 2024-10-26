package com.hash.harp.domain.user.controller.dto;

import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.domain.type.Authority;
import com.hash.harp.domain.user.domain.type.Gender;
import com.hash.harp.domain.user.domain.type.OauthType;

public record UserResponseDto(
        Long id,
        String username,
        String email,
        String birthday,
        String nickname,
        Gender gender,
        Authority authority,
        OauthType oauthType,
        String imgUrl
) {
    public static UserResponseDto from(final User user) {
        return new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getBirthday(), user.getNickname(), user.getGender(), user.getAuthority(), user.getOauthType(), user.getImgUrl());
    }
}
