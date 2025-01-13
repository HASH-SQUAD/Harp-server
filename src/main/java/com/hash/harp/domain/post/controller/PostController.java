package com.hash.harp.domain.post.controller;

import com.hash.harp.domain.auth.service.implementation.AuthReader;
import com.hash.harp.domain.post.controller.dto.PostListResponse;
import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.exception.CanNotSearchException;
import com.hash.harp.domain.post.service.CommandPostService;
import com.hash.harp.domain.post.service.QueryPostService;
import com.hash.harp.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final CommandPostService commandPostService;
    private final QueryPostService queryPostService;
    private final JwtService jwtService;
    private final AuthReader authReader;

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
    public List<PostListResponse> readPost() {
        return queryPostService.readAllPost();
    }

    @GetMapping("/{postId}")
    public Post read(@PathVariable Long postId) {
        return queryPostService.readPostById(postId);
    }

    @DeleteMapping("/{postId}")
    public void delete(@PathVariable Long postId) {
        commandPostService.deletePost(postId, authReader.getCurrentUser());
    }

    @PostMapping("/search")
    public List<PostListResponse> search(@RequestBody Map<String, String> request) {
        String keyword = request.get("keyword");
        List<PostListResponse> results = queryPostService.searchPosts(keyword);

        if (results.isEmpty()) {
            throw new CanNotSearchException();
        }

        return results;
    }
}
