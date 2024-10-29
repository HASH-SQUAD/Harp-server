package com.hash.harp.domain.comment.service;

import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.comment.repository.CommentRepository;
import com.hash.harp.domain.comment.service.implementation.CommentReader;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.service.implementation.PostReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class QueryCommentService {
    private final PostReader postReader;
    private final CommentReader commentReader;

    public List<Comment> findByPost(Long qnAId) {
        Post post = postReader.read(qnAId);
        return convertStructure(commentReader.readByPost(post));
    }

    private List<Comment> convertStructure(List<Comment> comments) {
        List<Comment> result = new ArrayList<>();
        Map<Long, Comment> map = new HashMap<>();
//        comments.forEach(
//                comment -> {
//                    map.put(comment.getId(), comment);
//                    if (comment.getParent() != null) {
//                        map.get(comment.getParent().getId()).getChildren().add(comment);
//                    } else {
//                        result.add(comment);
//                    }
//                }
//        );

        comments.forEach(comment -> {
            map.put(comment.getId(), comment);
            Optional.ofNullable(comment.getParent())
                    .map(parent -> map.get(parent.getId()).getChildren().add(comment))
                    .orElseGet(() -> result.add(comment));
        });

        return result;
    }
}
