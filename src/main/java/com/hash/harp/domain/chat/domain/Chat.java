package com.hash.harp.domain.chat.domain;

import com.hash.harp.domain.chat.domain.type.Type;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String chat;

    private LocalDateTime updateDateTime;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Builder
    public Chat(Long userId, String chat, LocalDateTime updateDateTime, Type type) {
        this.userId = userId;
        this.chat = chat;
        this.updateDateTime = updateDateTime;
        this.type = type;
    }
}
