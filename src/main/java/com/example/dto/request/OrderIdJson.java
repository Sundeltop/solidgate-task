package com.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record OrderIdJson(@JsonProperty("order_id") String orderId) {
}
