package com.hash.harp.domain.post.service;

import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.service.implementation.PostCreater;
import com.hash.harp.domain.post.service.implementation.PostDeleter;
import com.hash.harp.domain.post.service.implementation.PostUpdater;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandPostService {

    private final PostCreater postCreater;
    private final PostUpdater postUpdater;
    private final PostDeleter postDeleter;

    public void CreatePost(PostRequest request, Long userId) {
        postCreater.createPost(request, userId);
    }

    public void updatePost(PostRequest postRequest, Long id) {
        postUpdater.updatePost(postRequest, id);
    }

    public void deletePost(Long id) {
        postDeleter.deletePost(id);
    }
}
