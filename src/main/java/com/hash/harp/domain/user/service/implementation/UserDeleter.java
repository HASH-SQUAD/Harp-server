package com.hash.harp.domain.user.service.implementation;


import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserDeleter {
    private final UserRepository userRepository;

    public void delete(User userId) { userRepository.deleteById(userId.getId()); }
}