package com.hash.harp.domain.chat.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hash.harp.domain.chat.controller.dto.request.GPT.GPTRequest;
import com.hash.harp.domain.chat.controller.dto.request.chat.ChatRequest;
import com.hash.harp.domain.chat.controller.dto.response.AnswerResponse;
import com.hash.harp.domain.chat.controller.dto.response.ChatGPTResponse;
import com.hash.harp.domain.chat.controller.dto.response.Content;
import com.hash.harp.domain.chat.controller.dto.response.Text;
import com.hash.harp.domain.chat.service.CommandChatService;
import com.hash.harp.global.jwt.service.JwtService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final JwtService jwtService;

    private final CommandChatService commandChatService;

    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;


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

        return commandChatService.proccessChat(chatRequest, userId, chatId, "/travel");
    }
}