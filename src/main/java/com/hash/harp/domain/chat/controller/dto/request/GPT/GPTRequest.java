package com.hash.harp.domain.chat.controller.dto.request.GPT;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class GPTRequest {

    private String model;

    private List<GPTMessage> messages;

    private Double temperature;

    private int maxTokens;

    private int topP;

    private int frequencyPenalty;

    private int presencePenalty;

    private Map<String, String> responseFormat;

    public GPTRequest
            (
                    String model, String prompt, Double temperature, int maxTokens, int topP, int frequencyPenalty, int presencePenalty
            )
    {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new GPTMessage("user", prompt));
        this.temperature = temperature;
        this.maxTokens = maxTokens;
        this.topP = topP;
        this.frequencyPenalty = frequencyPenalty;
        this.presencePenalty = presencePenalty;
        this.responseFormat = Map.of("type", "json_object");
    }
}
