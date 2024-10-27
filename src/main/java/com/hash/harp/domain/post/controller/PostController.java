package com.hash.harp.domain.post.controller;

import com.hash.harp.domain.post.controller.dto.PostListResponse;
import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.controller.dto.PostResponse;
import com.hash.harp.domain.post.service.CommandPostService;
import com.hash.harp.domain.post.service.QueryPostService;
import com.hash.harp.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final CommandPostService commandPostService;
    private final QueryPostService queryPostService;
    private final JwtService jwtService;

    @PostMapping
    public ResponseEntity<String> create(HttpServletRequest request, @RequestBody PostRequest postRequest) {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        commandPostService.CreatePost(postRequest, userId);
        return ResponseEntity.ok("게시글이 작성되었습니다.");
    }

    @PutMapping("/{postId}")
    public ResponseEntity<String> update(@PathVariable Long postId, @RequestBody PostRequest postRequest) {
        commandPostService.updatePost(postRequest, postId);
        return ResponseEntity.ok("성공적으로 수정되었습니다.");
    }

    @GetMapping("/All")
    private List<PostListResponse> readPost() {
        return queryPostService.readAllPost();
    }

    @GetMapping("/{postId}")
    private List<PostResponse> read(@PathVariable Long postId) {
        return queryPostService.readPostById(postId);
    }

    @DeleteMapping("/{postId}")
    private ResponseEntity<String> delete(@PathVariable Long postId) {
        commandPostService.deletePost(postId);
        return ResponseEntity.ok("성공적으로 삭제되었습니다.");
    }
}
