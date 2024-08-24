package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PaymentPageResult(@JsonProperty("url") String url,
                                @JsonProperty("guid") String guid) {
}
