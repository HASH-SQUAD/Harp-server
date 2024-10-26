package com.hash.harp.domain.auth.controller;

import com.hash.harp.domain.auth.service.RefreshTokenService;
import com.hash.harp.global.jwt.dto.RefreshResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt")
public class JwtController {

    private final RefreshTokenService refreshTokenService;

    @PutMapping()
    public RefreshResponse refreshToken(@RequestHeader(value = "Refresh-Token") @NotBlank String refreshToken) {
        return refreshTokenService.execute(refreshToken);
    }
}
