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

    private Integer commentCount;

    @CreatedDate
    private LocalDateTime createTime;

    @Column(name = "user_id")
    private Long writer;


    @Builder
    public Post(String title, String content, String imgUrl, Long writer, Integer commentCount, LocalDateTime createTime) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
        this.createTime = createTime;
        this.writer = writer;
        this.commentCount = 0;
    }

    public void update(PostRequest request) {
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
}
