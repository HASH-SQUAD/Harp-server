package com.hash.harp.domain.auth.controller;

import com.hash.harp.domain.auth.service.AuthService;
import com.hash.harp.global.jwt.dto.RefreshResponse;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jwt")
public class JwtController {

    private final AuthService authService;

    @PutMapping()
    public RefreshResponse refreshToken(@RequestHeader(value = "Refresh-Token") @NotBlank String refreshToken) {
        return authService.execute(refreshToken);
    }
}
