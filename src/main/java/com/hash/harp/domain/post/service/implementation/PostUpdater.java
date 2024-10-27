package com.hash.harp.domain.post.service.implementation;

import com.hash.harp.domain.plan.exception.HeaderNotFoundException;
import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.exception.PostNotFoundException;
import com.hash.harp.domain.post.repository.PostRepository;
import com.hash.harp.domain.user.controller.dto.UserRequestDto;
import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostUpdater {

    private final PostRepository postRepository;

    public void updatePost(PostRequest postRequest, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));

        post.updatePost(postRequest);
    }
}
