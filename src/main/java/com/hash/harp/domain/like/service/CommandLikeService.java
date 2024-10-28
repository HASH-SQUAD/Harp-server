package com.hash.harp.domain.like.service;

import com.hash.harp.domain.like.domain.Like;
import com.hash.harp.domain.like.repository.LikeRepository;
import com.hash.harp.domain.like.service.implementation.LikeCreator;
import com.hash.harp.domain.like.service.implementation.LikeDeleter;
import com.hash.harp.domain.like.service.implementation.LikeReader;
import com.hash.harp.domain.like.service.implementation.LikeValidator;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.service.implementation.PostReader;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandLikeService {

    private final PostReader postReader;
    private final LikeCreator likeCreator;
    private final LikeValidator likeValidator;
    private final LikeReader likeReader;
    private final LikeDeleter likeDeleter;

    public void create(Long postId, User user) {
        Post post = postReader.readOne(postId);
        likeValidator.shouldNotExistLike(post, user);
        likeCreator.create(new Like(user, post));
        post.increaseLikeCount();
    }

    public void delete(Long postId, User user) {
        Post post = postReader.read(postId);
        Like like = likeReader.read(post, user);
        likeDeleter.delete(like);
        post.decreaseLikeCount();
    }
}
