package com.example.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.Date;
import java.util.List;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Builder
public record OrderJson(@JsonProperty("order_id") String orderId,
                        @JsonProperty("amount") long amount,
                        @JsonProperty("currency") String currency,
                        @JsonProperty("order_description") String orderDescription,
                        @JsonProperty("order_items") String orderItems,
                        @JsonProperty("order_date") @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd HH:mm:ss") Date orderDate,
                        @JsonProperty("order_number") int orderNumber,
                        @JsonProperty("type") String type,
                        @JsonProperty("settle_interval") int settleInterval,
                        @JsonProperty("retry_attempt") int retryAttempt,
                        @JsonProperty("force3ds") boolean force3ds,
                        @JsonProperty("google_pay_allowed_auth_methods") List<String> googlePayAllowedAuthMethods,
                        @JsonProperty("customer_date_of_birth") @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd") Date customerDateOfBirth,
                        @JsonProperty("customer_email") String customerEmail,
                        @JsonProperty("customer_first_name") String customerFirstName,
                        @JsonProperty("customer_last_name") String customerLastName,
                        @JsonProperty("customer_phone") String customerPhone,
                        @JsonProperty("traffic_source") String trafficSource,
                        @JsonProperty("transaction_source") String transactionSource,
                        @JsonProperty("purchase_country") String purchaseCountry,
                        @JsonProperty("geo_country") String geoCountry,
                        @JsonProperty("geo_city") String geoCity,
                        @JsonProperty("language") String language,
                        @JsonProperty("website") String website,
                        @JsonProperty("order_metadata") OrderMetadataJson orderMetadata,
                        @JsonProperty("success_url") String successUrl,
                        @JsonProperty("fail_url") String failUrl) {

    public record OrderMetadataJson(@JsonProperty("coupon_code") String couponCode,
                                    @JsonProperty("partner_id") String partnerId) {
    }
}
