package com.hash.harp.domain.chatGpt.controller;


import com.hash.harp.domain.chatGpt.controller.dto.ChatGPTRequest;
import com.hash.harp.domain.chatGpt.controller.dto.ChatGPTResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/gpt")
@RequiredArgsConstructor
public class GPTController {

    @Value("${gpt.model}")
    private String model;

    @Value("${gpt.api.url}")
    private String apiUrl;


    private final RestTemplate restTemplate;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){

        ChatGPTRequest request = new ChatGPTRequest(
                model, prompt,0.40,15000,1,0,0);

        ChatGPTResponse gptResponse = restTemplate.postForObject(
                apiUrl
                , request
                , ChatGPTResponse.class
        );


        return gptResponse.getChoices().get(0).getMessage().getContent();


    }
}