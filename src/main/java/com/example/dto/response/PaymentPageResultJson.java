package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PaymentPageResultJson(@JsonProperty("url") String url,
                                    @JsonProperty("guid") String guid) {
}
