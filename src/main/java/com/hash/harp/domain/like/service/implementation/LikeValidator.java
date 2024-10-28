package com.hash.harp.domain.like.service.implementation;

import com.hash.harp.domain.like.exception.AlreadyLikeException;
import com.hash.harp.domain.like.repository.LikeRepository;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeValidator {

    private final LikeRepository likeRepository;

    public void shouldNotExistLike(Post post, User user) {
        boolean isExist = likeRepository.existsByPostAndUser(post, user);

        if (isExist) {
            throw new AlreadyLikeException();
        }
    }

    public boolean checkLiked(Post post, User user) {
        return likeRepository.existsByPostAndUser(post, user);
    }
}

