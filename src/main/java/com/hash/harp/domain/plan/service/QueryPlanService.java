package com.hash.harp.domain.plan.service;

import com.hash.harp.domain.plan.controller.dto.response.HeaderResponseDto;
import com.hash.harp.domain.plan.controller.dto.response.PlanResponseDto;
import com.hash.harp.domain.plan.service.implementation.HeaderReader;
import com.hash.harp.domain.plan.service.implementation.PlanReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryPlanService {

    private final PlanReader planReader;
    private final HeaderReader headerReader;

    public List<PlanResponseDto> readPlan(Long headerId) {
        return planReader.readPlan(headerId);
    }

    public List<HeaderResponseDto> readAllHeader(Long userId) {
        return headerReader.readAll(userId);
    }
}
