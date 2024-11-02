package com.hash.harp.domain.post.domain;

import com.hash.harp.domain.post.controller.dto.PostRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30)
    private String title;

    @Column(length = 10000)
    private String content;

    private String imgUrl;

    @Column(nullable = false)
    private Long likeCount = 0L;

    @Column(nullable = false)
    private Long commentCount = 0L;

    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "user_id")
    private Long writer;

    private String category;


    @Builder
    public Post(String title, String content, String imgUrl, LocalDateTime createTime, Long writer, String category) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.writer = writer;
        this.category = category;
    }

    public void updatePost(PostRequest request) {
        this.title = request.title();
        this.content = request.content();
        this.imgUrl = request.imgUrl();
    }

    @PrePersist
    public void createAt() {
        this.createTime = LocalDateTime.now();
    }

    public void increaseCommentCount() {
        this.commentCount++;
    }

    public void decreaseCommentCount(long l) {
        this.commentCount--;
    }

    public void increaseLikeCount() {
        this.likeCount++;
    }

    public void decreaseLikeCount() {
        this.likeCount--;
    }
}
