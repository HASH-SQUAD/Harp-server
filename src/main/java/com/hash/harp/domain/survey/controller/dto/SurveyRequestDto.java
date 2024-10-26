package com.hash.harp.domain.survey.controller.dto;

import com.hash.harp.domain.survey.domain.type.Food;
import com.hash.harp.domain.survey.domain.type.Mbti;
import com.hash.harp.domain.survey.domain.type.Travel;

import java.util.List;
import java.util.stream.Collectors;

public record SurveyRequestDto(
        List<String> food,
        Mbti mbti,
        List<String> travel,
        String content
) {
    public List<Travel> getTravelAsEnum() {
        return travel.stream()
                .map(Travel::valueOf)
                .collect(Collectors.toList());
    }

    public List<Food> getFoodAsEnum() {
        return food.stream()
                .map(Food::valueOf)
                .collect(Collectors.toList());
    }
}