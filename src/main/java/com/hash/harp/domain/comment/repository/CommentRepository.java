package com.hash.harp.domain.comment.repository;

import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.comment.exception.CommentNotFoundException;
import com.hash.harp.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    void deleteByPost(Post post);

    List<Comment> findByPostId(Long postId);

    default Comment getById(Long commentId) {
        return findById(commentId)
                .orElseThrow(() -> new CommentNotFoundException());
    }
}
