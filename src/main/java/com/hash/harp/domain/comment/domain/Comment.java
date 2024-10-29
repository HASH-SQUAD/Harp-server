package com.hash.harp.domain.comment.domain;

import com.hash.harp.domain.post.domain.Post;
import com.hash.harp.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<Comment> children = new ArrayList<>();

    public Comment(String content) {
        this.content = content;
        this.createdAt = LocalDateTime.now();
    }

    public void updatePost(Post post) {
        this.post = post;
    }

    public void updateWriter(User writer) {
        this.writer = writer;
    }

    public void updateParent(Comment parent) {
        this.parent = parent;
    }

    public void update(Comment comment) {
        this.content = comment.getContent();
    }
}
