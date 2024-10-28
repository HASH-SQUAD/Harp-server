package com.hash.harp.domain.like.service.implementation;

import com.hash.harp.domain.like.domain.Like;
import com.hash.harp.domain.like.repository.LikeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeCreator {

    private final LikeRepository likeRepository;

    public void create(Like like) {
        likeRepository.save(like);
    }
}