package com.hash.harp.domain.post.service.implementation;

import com.hash.harp.domain.post.controller.dto.PostListResponse;
import com.hash.harp.domain.post.controller.dto.PostResponse;
import com.hash.harp.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostReader {
    private final PostRepository postRepository;

    public List<PostListResponse> readAll() {
        return postRepository.findAll().stream()
                .map(PostListResponse::of)
                .toList();
    }

    public List<PostResponse> readOne(Long postId) {
        postRepository.getById(postId);

        return postRepository.findById(postId).stream()
                .map(PostResponse::of)
                .toList();
    }

}
