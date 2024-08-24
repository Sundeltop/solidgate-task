package com.example.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record PageCustomizationJson(@JsonProperty("public_name") String publicName,
                                    @JsonProperty("order_title") String orderTitle,
                                    @JsonProperty("order_description") String orderDescription,
                                    @JsonProperty("payment_methods") List<String> paymentMethods,
                                    @JsonProperty("button_font_color") String buttonFontColor,
                                    @JsonProperty("button_color") String buttonColor,
                                    @JsonProperty("font_name") String fontName,
                                    @JsonProperty("is_cardholder_visible") boolean isCardholderVisible,
                                    @JsonProperty("terms_url") String termsUrl,
                                    @JsonProperty("back_url") String backUrl) {
}
