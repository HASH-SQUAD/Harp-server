package com.hash.harp.domain.like.repository;

import com.hash.harp.domain.like.domain.Like;
import com.hash.harp.domain.like.exception.LikeNotFoundException;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByPostAndUser(Post post, User user);

    Optional<Like> findByPostAndUser(Post post, User user);

    void deleteByPost(Post post);

    default Like getLike(Post post, User user) {
        return findByPostAndUser(post, user)
                .orElseThrow(LikeNotFoundException::new);
    }
}
