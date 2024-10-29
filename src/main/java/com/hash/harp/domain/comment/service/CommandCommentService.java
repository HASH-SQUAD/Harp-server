package com.hash.harp.domain.comment.service;

import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.comment.service.implementation.CommentCreater;
import com.hash.harp.domain.comment.service.implementation.CommentDeleter;
import com.hash.harp.domain.comment.service.implementation.CommentReader;
import com.hash.harp.domain.comment.service.implementation.CommentValidater;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.service.implementation.PostReader;
import com.hash.harp.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandCommentService {

    private final PostReader postReader;
    private final CommentReader commentReader;
    private final CommentCreater commentCreator;
    private final CommentValidater commentValidater;
    private final CommentDeleter commentDeleter;

    public void createComment(Long postId, User writer, Comment comment, Long parentId) {
        Post post = postReader.read(postId);
        commentCreator.create(
                comment,
                post,
                writer,
                parentId != null ? commentReader.read(parentId) : null
        );
        post.increaseCommentCount();
    }

    public void deleteComment(Long commentId, User writer) {
        Comment comment = commentReader.read(commentId);
        commentValidater.checkCommentAuthor(comment.getWriter(), writer);
        commentDeleter.delete(comment);
        postReader.read(comment.getPost().getId()).decreaseCommentCount(comment.getChildren().size() + 1L);
    }
}
