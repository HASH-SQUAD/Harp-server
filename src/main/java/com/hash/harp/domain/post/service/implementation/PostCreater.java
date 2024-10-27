package com.hash.harp.domain.post.service.implementation;

import com.hash.harp.domain.post.controller.dto.PostRequest;
import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.post.repository.PostRepository;
import com.hash.harp.domain.user.domain.User;
import com.hash.harp.domain.user.exception.UserNotFoundException;
import com.hash.harp.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PostCreater {

    private final PostRepository postRepository;

    private final UserRepository userRepository;

    public void createPost(PostRequest request, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Post post = Post.builder()
                .writer(user.getId())
                .title(request.title())
                .content(request.content())
                .imgUrl(request.imgUrl())
                .build();

        postRepository.save(post);
    }
}
