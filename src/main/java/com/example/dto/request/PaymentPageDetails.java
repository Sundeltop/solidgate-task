package com.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PaymentPageDetails {

    @JsonProperty("order")
    private Order order;

    @JsonProperty("page_customization")
    private PageCustomization pageCustomization;
}
