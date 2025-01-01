package com.hash.harp.domain.chat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hash.harp.domain.chat.controller.dto.request.chat.ChatRequest;
import com.hash.harp.domain.chat.controller.dto.response.ChatResponse;
import com.hash.harp.domain.chat.service.CommandChatService;
import com.hash.harp.domain.chat.service.QueryChatService;
import com.hash.harp.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final JwtService jwtService;

    private final CommandChatService commandChatService;
    private final QueryChatService queryChatService;

    @PostMapping("/travel/{chatId}")
    public Object createChatTravel(HttpServletRequest request, @RequestBody ChatRequest chatRequest, @PathVariable Long chatId) throws JsonProcessingException {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        return commandChatService.proccessChat(chatRequest, userId, chatId, "/travel");
    }

    @PostMapping("/date/{chatId}")
    public Object createChatDate(HttpServletRequest request, @RequestBody ChatRequest chatRequest, @PathVariable Long chatId) throws JsonProcessingException {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        return commandChatService.proccessChat(chatRequest, userId, chatId, "/date");
    }

    @GetMapping
    public List<ChatResponse> readChats(HttpServletRequest request) {
        return queryChatService.readAllChat();
    }
}