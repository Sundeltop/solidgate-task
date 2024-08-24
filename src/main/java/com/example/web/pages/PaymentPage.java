package com.example.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class PaymentPage {

    private final SelenideElement cardNumberInput = $("[data-testid='cardNumber']");
    private final SelenideElement cardExpiryInput = $("[data-testid='cardExpiryDate']");
    private final SelenideElement cvcInput = $("[data-testid='cardCvv']");
    private final SelenideElement nameOnCardInput = $("[data-testid='cardHolder']");
    private final SelenideElement submitPaymentBtn = $("button[data-testid='submit']");

    public PaymentPage setCardNumber(String cardNumber) {
        cardNumberInput
                .shouldBe(visible, editable)
                .setValue(cardNumber);

        return this;
    }

    public PaymentPage setCardExpiry(String cardExpiry) {
        cardExpiryInput
                .shouldBe(visible, editable)
                .setValue(cardExpiry);

        return this;
    }

    public PaymentPage setCvc(String cvc) {
        cvcInput
                .shouldBe(visible, editable)
                .setValue(cvc);

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
    }
}
