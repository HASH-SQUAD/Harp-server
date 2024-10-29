package com.hash.harp.domain.comment.controlle;


import com.hash.harp.domain.auth.service.implementation.AuthReader;
import com.hash.harp.domain.comment.controlle.dto.CommentRequest;
import com.hash.harp.domain.comment.domain.Comment;
import com.hash.harp.domain.comment.service.CommandCommentService;
import com.hash.harp.domain.comment.service.implementation.CommentCreater;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommandCommentService commandCommentService;
    private final AuthReader authReader;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{postId}")
    public void createComment(
            @PathVariable(name = "postId") Long postId,
            @RequestBody CommentRequest request
    ) {
        commandCommentService.createComment(postId, authReader.getCurrentUser(), request.toEntity(),
                request.parent());
    }
}
