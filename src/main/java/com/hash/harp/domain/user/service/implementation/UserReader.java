package com.hash.harp.domain.user.service.implementation;

import com.hash.harp.domain.survey.exception.SurveyNotFoundException;
import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserReader {

    private final UserRepository userRepository;

    public User readOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->  new SurveyNotFoundException(id));
    }
}
