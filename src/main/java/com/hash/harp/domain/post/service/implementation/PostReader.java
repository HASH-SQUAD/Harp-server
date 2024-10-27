package com.hash.harp.domain.post.service.implementation;

import com.hash.harp.domain.plan.controller.dto.response.HeaderResponseDto;
import com.hash.harp.domain.plan.controller.dto.response.PlanResponseDto;
import com.hash.harp.domain.post.controller.dto.PostListResponse;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.repository.PostRepository;
import com.hash.harp.domain.survey.exception.SurveyNotFoundException;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
@RequiredArgsConstructor
public class PostReader {
    private final PostRepository postRepository;

    public List<PostListResponse> readAll() {
        return postRepository.findAll().stream()
                .map(PostListResponse::of)
                .toList();
    }
}
