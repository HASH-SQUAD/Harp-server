package com.hash.harp.domain.post.service;


import com.hash.harp.domain.plan.controller.dto.response.HeaderResponseDto;
import com.hash.harp.domain.post.controller.dto.PostListResponse;
import com.hash.harp.domain.post.service.implementation.PostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryPostService {
    private final PostReader postReader;

    public List<PostListResponse> readAllPost() {
        return postReader.readAll();
    }
}
