package com.hash.harp.domain.comment.service.implementation;

import com.hash.harp.domain.comment.domain.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentUpdater {

    public void update(Comment updatableComment, Comment comment) {
        updatableComment.update(comment);
    }
}