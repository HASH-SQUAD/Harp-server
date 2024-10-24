package com.hash.harp.domain.chat.repository;

import com.hash.harp.domain.chat.domain.Chat;
import com.hash.harp.domain.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
