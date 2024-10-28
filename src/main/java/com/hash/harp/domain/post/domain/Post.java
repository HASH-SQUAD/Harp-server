package com.hash.harp.domain.post.domain;

import com.hash.harp.domain.post.controller.dto.PostRequest;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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


    @Builder
    public Post(String title, String content, String imgUrl, LocalDateTime createTime, Long writer) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.writer = writer;
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

    public void decreaseCommentCount() {
        this.commentCount--;
    }

    public void increaseLikeCount() {
        this.likeCount++;
    }

    public void decreaseLikeCount() {
        this.likeCount--;
    }
}
