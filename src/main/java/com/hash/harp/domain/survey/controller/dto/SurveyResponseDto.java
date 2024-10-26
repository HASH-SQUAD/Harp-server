package com.hash.harp.domain.survey.controller.dto;

import com.hash.harp.domain.survey.domain.Survey;
import com.hash.harp.domain.survey.domain.type.Food;
import com.hash.harp.domain.survey.domain.type.Mbti;
import com.hash.harp.domain.survey.domain.type.Travel;

import java.util.List;
import java.util.stream.Collectors;

public record SurveyResponseDto(
        Long id,
        Long userId,
        List<String> food,
        Mbti mbti,
        List<String> travel,
        String content
) {
    public static SurveyResponseDto from(final Survey survey) {
        List<String> travelList = survey.getTravel().stream()
                .map(Enum::name)
                .collect(Collectors.toList());

        List<String> foodList = survey.getFood().stream()
                .map(Enum::name)
                .collect(Collectors.toList());

        return new SurveyResponseDto(
                survey.getId(),
                survey.getUserId(),
                foodList,
                survey.getMbti(),
                travelList,
                survey.getContent()
        );
    }
}
