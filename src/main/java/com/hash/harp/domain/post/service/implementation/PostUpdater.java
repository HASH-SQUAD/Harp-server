package com.hash.harp.domain.post.service.implementation;

import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostUpdater {

    private final PostRepository postRepository;

    public void updatePost(PostRequest postRequest, Long id) {
        Post post = postRepository.getById(id);
        post.updatePost(postRequest);
    }
}
