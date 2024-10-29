package com.hash.harp.domain.comment.service.implementation;

import com.hash.harp.domain.comment.exception.CommentNotAuthorException;
import com.hash.harp.domain.user.domain.User;
import org.springframework.stereotype.Service;

@Service
public class CommentValidator {
    public void checkCommentAuthor(User commentWriter, User writer) {
        if (!commentWriter.getId().equals(writer.getId())) {
            throw new CommentNotAuthorException();
        }
    }
}
