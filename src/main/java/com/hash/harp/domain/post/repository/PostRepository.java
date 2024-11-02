package com.hash.harp.domain.post.repository;

import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.exception.PostNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    default Post getById(Long id) {
        return findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    List<Post> findByTitleContainingOrContentContaining(String titleKeyword, String contentKeyword);
}