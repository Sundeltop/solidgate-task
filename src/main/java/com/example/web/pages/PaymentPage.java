package com.example.web.pages;

import com.codeborne.selenide.SelenideElement;

import java.util.regex.Matcher;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static java.util.regex.Pattern.compile;

public class PaymentPage {

    private final SelenideElement cardNumberInput = $("[data-testid='cardNumber']");
    private final SelenideElement cardExpiryInput = $("[data-testid='cardExpiryDate']");
    private final SelenideElement cvcInput = $("[data-testid='cardCvv']");
    private final SelenideElement nameOnCardInput = $("[data-testid='cardHolder']");
    private final SelenideElement submitPaymentBtn = $("button[data-testid='submit']");
    private final SelenideElement loadingSpinner = $(".CardForm_spinner__oFYh8");
    private final SelenideElement orderPrice = $("[data-testid='price_major']");

    public PaymentPage setCardNumber(String cardNumber) {
        cardNumberInput
                .shouldBe(visible, editable)
                .setValue(cardNumber)
                .shouldHave(value(cardNumber.replaceAll("(.{4})", "$1 ")));

        return this;
    }

    public String getCurrency() {
        return parseOrderPrice().group(1);
    }

    public String getOrderAmount() {
        return parseOrderPrice().group(2);
    }

    public PaymentPage setCardExpiry(String cardExpiry) {
        cardExpiryInput
                .shouldBe(visible, editable)
                .setValue(cardExpiry)
                .shouldHave(value(cardExpiry));

        return this;
    }

    public PaymentPage setCvc(String cvc) {
        cvcInput
                .shouldBe(visible, editable)
                .setValue(cvc)
                .shouldHave(value(cvc));

        return this;
    }

    public PaymentPage setNameOnCard(String nameOnCard) {
        nameOnCardInput
                .shouldBe(visible, editable)
                .setValue(nameOnCard);

        return this;
    }

    public void pay() {
        submitPaymentBtn
                .shouldBe(visible, clickable)
                .click();

        loadingSpinner.shouldNotBe(visible);
        submitPaymentBtn.shouldNotBe(visible);
    }

    private Matcher parseOrderPrice() {
        final String regex = "([€£$])([0-9,.]+)";

        final String currencyWithAmount = orderPrice
                .shouldBe(visible)
                .text();

        final Matcher matcher = compile(regex).matcher(currencyWithAmount);

        if (matcher.matches()) {
            return matcher;
        }

        throw new RuntimeException("Error occurred during parsing order price");
    }
}
