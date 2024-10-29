package com.hash.harp.domain.comment.service.implementation;

import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.comment.repository.CommentRepository;
import com.hash.harp.domain.post.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentReader {

    private final CommentRepository commentRepository;

    public Comment read(Long commentId) {
        return commentRepository.getById(commentId);
    }

    public List<Comment> readByPost(Post post) {
        return commentRepository.findByPostId(post.getId());
    }
}
