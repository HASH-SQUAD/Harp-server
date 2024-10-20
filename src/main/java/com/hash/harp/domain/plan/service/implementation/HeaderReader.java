package com.hash.harp.domain.plan.service.implementation;

import com.hash.harp.domain.plan.controller.dto.response.HeaderResponseDto;
import com.hash.harp.domain.plan.domain.Header;
import com.hash.harp.domain.plan.repository.HeaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeaderReader {

    private final HeaderRepository headerRepository;

    public List<HeaderResponseDto> readAll(Long userId) {
        return headerRepository.findByUserId(userId).stream()
                .map(HeaderResponseDto::from)
                .toList();
    }
}
