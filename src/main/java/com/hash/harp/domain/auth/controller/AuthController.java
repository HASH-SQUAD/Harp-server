package com.hash.harp.domain.auth.controller;

import com.hash.harp.domain.auth.service.GoogleLoginService;
import com.hash.harp.domain.auth.service.KakaoLoginService;
import com.hash.harp.global.jwt.dto.TokenResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final GoogleLoginService googleLoginService;
    private final KakaoLoginService kakaoLoginService;

    @PostMapping("/login/google")
    public TokenResponse loginOfGoogle(@Valid @RequestParam(name = "code") String code)  {
        return googleLoginService.login(code);
    }

    @PostMapping("/login/kakao")
    public TokenResponse loginOfKakao(@Valid @RequestParam(name = "code") String code) {
        return kakaoLoginService.login(code);
    }
}
