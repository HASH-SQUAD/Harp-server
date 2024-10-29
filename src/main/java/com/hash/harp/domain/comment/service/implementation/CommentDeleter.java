package com.hash.harp.domain.comment.service.implementation;

import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.comment.repository.CommentRepository;
import com.hash.harp.domain.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentDeleter {
    private final CommentRepository commentRepository;

    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    public void deleteByPost(Post post) {
        commentRepository.deleteByPost(post);
    }
}
