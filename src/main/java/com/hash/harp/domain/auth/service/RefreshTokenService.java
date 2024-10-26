package com.hash.harp.domain.auth.service;

import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.repository.UserRepository;
import com.hash.harp.global.jwt.dto.RefreshResponse;
import com.hash.harp.global.jwt.properties.JwtConstants;
import com.hash.harp.global.jwt.util.JwtProvider;
import com.hash.harp.global.jwt.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    private final JwtProvider jwtProvider;

    public RefreshResponse execute(String token) {

        String email;

        try {
            email = jwtUtil.getJwt(jwtUtil.parseToken(token)).getBody().get(JwtConstants.AUTH_ID.message).toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("유효하지 않은 RefreshToken입니다.");
        }

        Optional<User> user = userRepository.findByEmail(email);
        String newAccessToken = jwtProvider.generateAccessToken(user.get().getId(), user.get().getAuthority().toString(), String.valueOf(false));

        return RefreshResponse.builder()
                .accessToken(newAccessToken)
                .build();
    }
}
