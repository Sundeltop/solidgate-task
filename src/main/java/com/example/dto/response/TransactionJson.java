package com.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TransactionJson(@JsonProperty("status") String status,
                              @JsonProperty("amount") Long amount,
                              @JsonProperty("currency") String currency) {
}
