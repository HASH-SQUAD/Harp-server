package com.hash.harp.domain.post.service;

import com.hash.harp.domain.post.controller.dto.PostListResponse;
import com.hash.harp.domain.post.domain.Post;
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

    public Post readPostById(Long postId) {
        return postReader.readOne(postId);
    }
}
