package com.hash.harp.domain.survey.service;

import com.hash.harp.domain.survey.controller.dto.SurveyRequestDto;
import com.hash.harp.domain.survey.domain.Survey;
import com.hash.harp.domain.survey.repository.SurveyRepository;
import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.exception.UserNotFoundException;
import com.hash.harp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandSurveyService {

    private final SurveyRepository surveyRepository;
    private final UserRepository userRepository;

    public void createSurvey(SurveyRequestDto surveyRequestDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Survey survey = Survey.builder()
                .userId(user.getId())
                .travel(surveyRequestDto.getTravelAsEnum())
                .food(surveyRequestDto.getFoodAsEnum())
                .mbti(surveyRequestDto.mbti())
                .content(surveyRequestDto.content())
                .build();

        surveyRepository.save(survey);

        if (user.getIsFirst()) {
            user.update();
            userRepository.save(user);
        }
    }
}
