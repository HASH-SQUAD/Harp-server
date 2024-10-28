package com.hash.harp.domain.like.controller;

import com.hash.harp.domain.auth.service.implementation.AuthReader;
import com.hash.harp.domain.like.service.CommandLikeService;
import com.hash.harp.domain.like.service.QueryLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikeController {

    private final CommandLikeService commandLikeService;
    private final QueryLikeService queryLikeService;
    private final AuthReader authReader;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{postId}")
    public void createLike(@PathVariable(name = "postId") Long postId) {
        commandLikeService.create(postId, authReader.getCurrentUser());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{postId}")
    public void deleteLike(@PathVariable(name = "postId") Long postId) {
        commandLikeService.delete(postId, authReader.getCurrentUser());
    }

    @GetMapping("/{postId}")
    public boolean checkLiked(@PathVariable(name = "postId") Long postId) {
        return queryLikeService.checkLike(postId, authReader.getCurrentUser());
    }
}
