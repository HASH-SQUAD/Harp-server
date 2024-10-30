package com.hash.harp.domain.chat.controller.dto.response.result;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Schedule(
        String time,
        String activity,
        String recommendation,
        String location,
        String storeName,

        @JsonProperty("place_url")
        String placeUrl,

        String x,
        String y
) {
}
