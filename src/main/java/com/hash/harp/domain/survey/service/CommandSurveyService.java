package com.hash.harp.domain.survey.service;

import com.hash.harp.domain.survey.controller.dto.SurveyRequestDto;
import com.hash.harp.domain.survey.service.implementation.SurveyCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandSurveyService {

    private final SurveyCreator surveyCreator;

    public void createSurvey(SurveyRequestDto surveyRequestDto, Long userId) {
        surveyCreator.createSurvey(surveyRequestDto, userId);
    }
}
