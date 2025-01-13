package com.hash.harp.domain.user.service;

import com.hash.harp.domain.user.controller.dto.UserRequestDto;
import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.exception.UserNotFoundException;
import com.hash.harp.domain.user.repository.UserRepository;
import com.hash.harp.domain.user.service.implementation.ProfileUpdater;
import com.hash.harp.domain.user.service.implementation.UserDeleter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandUserService {
    private final UserDeleter userDeleter;
    private final UserRepository userRepository;
    private final ProfileUpdater profileUpdater;

    public void update(UserRequestDto userRequestDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        user.updateUserInfo(userRequestDto);
    }

    public void updateProfile(UserRequestDto userRequestDto, Long id) {
        profileUpdater.updateProfile(userRequestDto, id);
    }

    public void delete(User id) {
        userDeleter.delete(id);
    }
}
