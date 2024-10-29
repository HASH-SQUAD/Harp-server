package com.hash.harp.domain.comment.controlle;


import com.hash.harp.domain.auth.service.implementation.AuthReader;
import com.hash.harp.domain.comment.controlle.dto.CommentRequest;
import com.hash.harp.domain.comment.service.CommandCommentService;
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

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable(name = "commentId") Long commentId) {
        commandCommentService.deleteComment(commentId, authReader.getCurrentUser());
    }

    @PutMapping("/{commentId}")
    public void updateComment(
            @PathVariable(name = "ccommentId") Long commentId,
            @RequestBody CommentRequest request
    ) {
        commandCommentService.updateComment(commentId, request.toEntity(), authReader.getCurrentUser());
    }
}
