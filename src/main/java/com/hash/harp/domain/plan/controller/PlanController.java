package com.hash.harp.domain.plan.controller;

import com.hash.harp.domain.plan.controller.dto.request.HeaderRequestDto;
import com.hash.harp.domain.plan.controller.dto.request.PlanRequestDto;
import com.hash.harp.domain.plan.controller.dto.response.HeaderCreateResponse;
import com.hash.harp.domain.plan.controller.dto.response.HeaderResponseDto;
import com.hash.harp.domain.plan.controller.dto.response.PlanResponseDto;
import com.hash.harp.domain.plan.service.CommandPlanService;
import com.hash.harp.domain.plan.service.QueryPlanService;
import com.hash.harp.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/plan")
public class PlanController {

    private final CommandPlanService commandPlanService;

    private final QueryPlanService queryPlanService;

    private final JwtService jwtService;

    @PostMapping("/header")
    private HeaderCreateResponse createHeader(HttpServletRequest request, @RequestBody HeaderRequestDto headerRequestDto) {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        return commandPlanService.createHeader(headerRequestDto, userId);
    }

    @PostMapping("/day/{headerId}")
    private void createPlan(@RequestBody PlanRequestDto planRequestDto, @PathVariable Long headerId) {
        commandPlanService.creatPlan(planRequestDto, headerId);
    }

    @PutMapping("/day/{headerId}")
    private void updatePlan(
            @PathVariable(name = "headerId") Long headerId,
            @RequestBody PlanRequestDto planRequestDto
    ) {
        commandPlanService.updatePlan(planRequestDto, headerId);
    }

    @DeleteMapping("/day/{headerId}")
    private void deletePlan(@PathVariable(name = "headerId") Long headerId) {
        commandPlanService.deletePlan(headerId);
    }

    @GetMapping("/day/{headerId}")
    private List<PlanResponseDto> readPlan(@PathVariable(name = "headerId") Long headerId) {
        return queryPlanService.readPlan(headerId);
    }

    @GetMapping("/header")
    private List<HeaderResponseDto> readHeader(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        return queryPlanService.readAllHeader(userId);
    }

    @PutMapping("/S3/{headerId}")
    private void updateHeaderImg(@RequestBody HeaderRequestDto headerRequestDto, @PathVariable(name = "headerId") Long headerId) {
        commandPlanService.updateHeaderImg(headerRequestDto, headerId);
    }
}
