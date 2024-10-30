package com.hash.harp.domain.plan.domain;

import com.hash.harp.domain.plan.controller.dto.request.PlanRequestDto;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "header_id")
    private Long headerId;

    private String day;

    @Column(name = "time", columnDefinition = "TIME")
    private LocalTime time;

    private String activity;

    private String location;

    private String storeName;

    private String placeUrl;

    private String content;


    @Builder
    public Plan(String day, LocalTime time, String activity, String location, String storeName, String placeUrl, Long headerId, String content) {
        this.day = day;
        this.time = time;
        this.activity = activity;
        this.location = location;
        this.storeName = storeName;
        this.placeUrl = placeUrl;
        this.headerId = headerId;
        this.content = content;
    }

    public void updatePlan(PlanRequestDto planRequestDto) {
        this.day = planRequestDto.getPlans().keySet().stream().findFirst().orElse(this.day);
        this.activity = planRequestDto.getPlans().get(this.day).get(0).getActivity();
        this.time = LocalTime.parse(planRequestDto.getPlans().get(this.day).get(0).getTime());
    }
}
