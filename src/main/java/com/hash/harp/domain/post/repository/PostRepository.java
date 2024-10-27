package com.hash.harp.domain.post.repository;

import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.exception.PostNotFoundException;
import com.hash.harp.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

    default Post getById(Long id) {
        return findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }
}