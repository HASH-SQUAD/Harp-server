package com.hash.harp.domain.plan.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class  PlanRequestDto {
    private Map<String, List<ActivityDto>> plans = new HashMap<>();

    @Getter
    @NoArgsConstructor
    public static class ActivityDto {
        private String time;
        private String activity;
        private String storeName;
        private String location;
        private String placeUrl;
        private String content;
    }
}