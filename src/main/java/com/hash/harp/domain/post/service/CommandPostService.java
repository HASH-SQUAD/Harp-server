package com.hash.harp.domain.post.service;

import com.hash.harp.domain.comment.service.implementation.CommentDeleter;
import com.hash.harp.domain.like.service.implementation.LikeDeleter;
import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.service.implementation.PostCreator;
import com.hash.harp.domain.post.service.implementation.PostDeleter;
import com.hash.harp.domain.post.service.implementation.PostReader;
import com.hash.harp.domain.post.service.implementation.PostUpdater;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandPostService {

    private final PostCreator postCreator;
    private final PostUpdater postUpdater;
    private final PostDeleter postDeleter;
    private final PostReader postReader;
    private final LikeDeleter likeDeleter;
    private final CommentDeleter commentDeleter;

    public void CreatePost(PostRequest request, Long userId) {
        postCreator.createPost(request, userId);
    }

    public void updatePost(PostRequest postRequest, Long id) {
        postUpdater.updatePost(postRequest, id);
    }

    public void deletePost(Long id, User currentUser) {
        Post post = postReader.read(id);
        postDeleter.deletePost(id);
        likeDeleter.deleteByPost(post);
        commentDeleter.deleteByPost(post);
    }
}
