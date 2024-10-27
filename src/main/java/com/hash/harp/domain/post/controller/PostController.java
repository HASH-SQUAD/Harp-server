package com.hash.harp.domain.post.controller;

import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.service.CommandPostService;
import com.hash.harp.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final CommandPostService commandPostService;

    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<Void> create(HttpServletRequest request, @RequestBody PostRequest postRequest) {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        commandPostService.CreatePost(postRequest, userId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Void> update(@PathVariable Long postId, @RequestBody PostRequest postRequest) {
        commandPostService.updatePost(postRequest, postId);
        return ResponseEntity.noContent().build();
    }
}
