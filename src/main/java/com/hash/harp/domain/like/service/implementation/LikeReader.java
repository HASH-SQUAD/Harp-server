package com.hash.harp.domain.like.service.implementation;

import com.hash.harp.domain.like.domain.Like;
import com.hash.harp.domain.like.repository.LikeRepository;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeReader {

    private final LikeRepository likeRepository;

    public Like read(Post post, User user) {
        return likeRepository.getLike(post, user);
    }
}
