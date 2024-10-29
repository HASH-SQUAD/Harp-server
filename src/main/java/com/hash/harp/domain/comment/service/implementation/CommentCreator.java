package com.hash.harp.domain.comment.service.implementation;

import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.comment.repository.CommentRepository;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentCreator {
    private final CommentRepository commentRepository;

    public void create(Comment comment, Post post, User writer, Comment parent) {
        comment.updatePost(post);
        comment.updateWriter(writer);
        comment.updateParent(parent);
        commentRepository.save(comment);
    }
}
