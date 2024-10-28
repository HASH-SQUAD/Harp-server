package com.hash.harp.domain.auth.service.implementation;

import com.hash.harp.domain.auth.repository.AuthRepository;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthReader {
    private final AuthRepository authRepository;

    public User getCurrentUser() {
        return authRepository.getCurrentUser();
    }
}