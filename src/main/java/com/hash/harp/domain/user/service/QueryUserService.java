package com.hash.harp.domain.user.service;

import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.service.implementation.UserReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryUserService {

    private final UserReader userReader;

    public User readById(Long id) {
        return userReader.readOne(id);
    }
}
