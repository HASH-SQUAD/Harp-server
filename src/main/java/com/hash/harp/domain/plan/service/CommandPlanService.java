package com.hash.harp.domain.plan.service;

import com.hash.harp.domain.plan.controller.dto.request.HeaderRequestDto;
import com.hash.harp.domain.plan.controller.dto.request.PlanRequestDto;
import com.hash.harp.domain.plan.controller.dto.response.HeaderCreateResponse;
import com.hash.harp.domain.plan.controller.dto.response.HeaderResponseDto;
import com.hash.harp.domain.plan.domain.Header;
import com.hash.harp.domain.plan.service.implementation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class CommandPlanService {

    private final PlanCreator planCreator;

    private final PlanUpdater planUpdater;

    private final PlanDeleter planDeleter;

    private final HeaderCreator headerCreator;

    private final HeaderUpdater headerUpdater;


    public HeaderCreateResponse createHeader(HeaderRequestDto headerRequestDto, Long userId) {
        Header header = headerCreator.createHeader(headerRequestDto, userId);
        return new HeaderCreateResponse("헤더 생성 완료", header.getId());
    }

    public void creatPlan(PlanRequestDto planRequestDto, Long headerId) {
        planCreator.createPlan(planRequestDto, headerId);
    }

    public void updatePlan(
            PlanRequestDto planRequestDto, Long headerId
    ) {
        planUpdater.updatePlan(planRequestDto, headerId);
    }

    public void deletePlan(Long headerId) {
        planDeleter.deletePlan(headerId);
    }

    public void updateHeaderImg(HeaderRequestDto headerRequestDto, Long headerId) {
        headerUpdater.updateHeaderImg(headerRequestDto, headerId);
    }
}
