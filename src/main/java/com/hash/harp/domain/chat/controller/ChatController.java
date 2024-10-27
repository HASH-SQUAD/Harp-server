package com.hash.harp.domain.chat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hash.harp.domain.chat.controller.dto.request.chat.ChatRequest;
import com.hash.harp.domain.chat.controller.dto.response.AnswerResponse;
import com.hash.harp.domain.chat.service.CommandChatService;
import com.hash.harp.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final JwtService jwtService;

    private final CommandChatService commandChatService;

    @PostMapping("/travel/{chatId}")
    public AnswerResponse createChatTravel(HttpServletRequest request, @RequestBody ChatRequest chatRequest, @PathVariable Long chatId) throws JsonProcessingException {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        return commandChatService.proccessChat(chatRequest, userId, chatId, "/travel");
    }

    @PostMapping("/date/{chatId}")
    public AnswerResponse createChatDate(HttpServletRequest request, @RequestBody ChatRequest chatRequest, @PathVariable Long chatId) throws JsonProcessingException {
        String token = request.getHeader("Authorization");
        Long userId = jwtService.getUserIdFromToken(token);

        return commandChatService.proccessChat(chatRequest, userId, chatId, "/date");
    }
}