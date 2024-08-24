package com.example.testdata;

import com.example.dto.request.Order;
import com.example.dto.request.Order.OrderMetadata;
import com.example.dto.request.PageCustomization;
import com.example.dto.request.PaymentPageDetails;
import com.github.javafaker.Faker;

import java.util.List;

import static java.util.UUID.randomUUID;

public class TestDataStorage {

    private final Faker faker;

    public TestDataStorage() {
        faker = new Faker();
    }

    public PaymentPageDetails generatePaymentPageDetails() {
        return new PaymentPageDetails(generateOrder(), generatePageCustomization());
    }

    private Order generateOrder() {
        return Order.builder()
                .orderId(randomUUID().toString())
                .amount(faker.number().numberBetween(1000, 2000))
                .currency("EUR")
                .orderDescription(faker.lorem().sentence())
                .orderItems(faker.commerce().productName() + " x " + faker.number().numberBetween(1, 5))
                .orderDate(faker.date().birthday())
                .orderNumber(faker.number().numberBetween(1, 10))
                .type("auth")
                .settleInterval(faker.number().numberBetween(0, 5))
                .retryAttempt(faker.number().numberBetween(0, 5))
                .force3ds(faker.bool().bool())
                .googlePayAllowedAuthMethods(List.of("PAN_ONLY"))
                .customerDateOfBirth(faker.date().birthday())
                .customerEmail(faker.internet().emailAddress())
                .customerFirstName(faker.name().firstName())
                .customerLastName(faker.name().lastName())
                .customerPhone(faker.phoneNumber().cellPhone())
                .trafficSource(faker.internet().domainName())
                .transactionSource(faker.lorem().word())
                .purchaseCountry("USA")
                .geoCountry("USA")
                .geoCity("New Castle")
                .language("pt")
                .website("https://solidgate.com")
                .orderMetadata(generateOrderMetadata())
                .successUrl("http://merchant.example/success")
                .failUrl("http://merchant.example/fail")
                .build();
    }

    private OrderMetadata generateOrderMetadata() {
        return new OrderMetadata("NY2018", "123989");
    }

    private PageCustomization generatePageCustomization() {
        return PageCustomization.builder()
                .publicName(faker.company().name())
                .orderTitle(faker.commerce().productName())
                .orderDescription(faker.lorem().sentence())
                .paymentMethods(List.of("paypal"))
                .buttonFontColor("#FFFFFF")
                .buttonColor("#00816A")
                .fontName("Open Sans")
                .isCardholderVisible(true)
                .termsUrl("https://solidgate.com/terms")
                .backUrl("https://solidgate.com")
                .build();
    }
}
