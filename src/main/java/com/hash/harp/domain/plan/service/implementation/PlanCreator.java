package com.hash.harp.domain.plan.service.implementation;

import com.hash.harp.domain.plan.controller.dto.request.HeaderRequestDto;
import com.hash.harp.domain.plan.controller.dto.request.PlanRequestDto;
import com.hash.harp.domain.plan.domain.Header;
import com.hash.harp.domain.plan.domain.Plan;
import com.hash.harp.domain.plan.repository.HeaderRepository;
import com.hash.harp.domain.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PlanCreator {

    private final PlanRepository planRepository;

    public void createPlan(PlanRequestDto planRequestDto, Long headerId) {

        Map<String, List<PlanRequestDto.ActivityDto>> plans = planRequestDto.getPlans();

        if (plans != null) {
            plans.forEach((day, activities) -> {
                activities.forEach(activityDto -> {
                    Plan plan = Plan.builder()
                            .headerId(headerId)
                            .day(day)
                            .time(LocalTime.parse(activityDto.getTime()))
                            .activity(activityDto.getActivity())
                            .location(activityDto.getLocation())
                            .storeName(activityDto.getStoreName())
                            .placeUrl(activityDto.getPlaceUrl())
                            .content(activityDto.getContent())
                            .build();

                    planRepository.save(plan);

                    System.out.println(LocalTime.parse(activityDto.getTime()));
                });
            });
        }
    }
}
