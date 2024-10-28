package com.hash.harp.domain.like.service.implementation;

import com.hash.harp.domain.like.domain.Like;
import com.hash.harp.domain.like.repository.LikeRepository;
import com.hash.harp.domain.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeDeleter {

    private final LikeRepository likeRepository;

    public void delete(Like like) {
        likeRepository.delete(like);
    }

    public void deleteByPost(Post post) {
        likeRepository.deleteByPost(post);
    }
}
