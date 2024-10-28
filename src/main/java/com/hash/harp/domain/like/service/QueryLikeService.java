package com.hash.harp.domain.like.service;

import com.hash.harp.domain.like.service.implementation.LikeValidator;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.service.implementation.PostReader;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryLikeService {

    private final PostReader postReader;
    private final LikeValidator likeValidator;

    public boolean checkLike(Long postId, User user) {
        Post post = postReader.read(postId);
        return likeValidator.checkLiked(post, user);
    }
}