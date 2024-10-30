package com.hash.harp.domain.plan.service.implementation;

import com.hash.harp.domain.plan.controller.dto.request.HeaderRequestDto;
import com.hash.harp.domain.plan.domain.Header;
import com.hash.harp.domain.plan.repository.HeaderRepository;
import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.exception.UserNotFoundException;
import com.hash.harp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HeaderCreator {

    private final UserRepository userRepository;

    private final HeaderRepository headerRepository;

    public Header createHeader(HeaderRequestDto headerRequestDto, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Header header = Header.builder()
                .userId(user.getId())
                .title(headerRequestDto.title())
                .d_day(headerRequestDto.d_day())
                .startDay(headerRequestDto.startDate())
                .endDay(headerRequestDto.endDate())
                .duration(headerRequestDto.duration())
                .build();

        return headerRepository.save(header);
    }
}
