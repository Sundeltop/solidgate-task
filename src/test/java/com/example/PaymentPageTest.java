package com.example;

import com.example.dto.request.PaymentPageDetails;
import com.example.dto.response.PaymentPageResult;
import com.example.service.PaymentService;
import com.example.testdata.TestDataStorage;
import com.example.web.pages.PaymentPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static java.time.LocalDate.now;

public class PaymentPageTest {

    private static final String VALID_CARD_NUMBER = "4067429974719265";

    private final PaymentService paymentService = new PaymentService();
    private final TestDataStorage testDataStorage = new TestDataStorage();
    private final Faker faker = new Faker();

    @Test(description = "Verify Payment page is created and order is successfully payed")
    public void verifyPaymentPageIsCreatedAndOrderIsSuccessfullyPayed() {
        final PaymentPageDetails paymentPageDetails = testDataStorage.generatePaymentPageDetails();

        final PaymentPageResult paymentPage = paymentService.createPaymentPage(paymentPageDetails);

        open(paymentPage.url(), PaymentPage.class)
                .setCardNumber(VALID_CARD_NUMBER)
                .setCardExpiry(getValidCardExpiry())
                .setCvc(faker.number().digits(3))
                .setNameOnCard(faker.name().fullName())
                .pay();
    }

    private String getValidCardExpiry() {
        final int month = faker.number().numberBetween(1, 12);
        final int year = faker.number().numberBetween(now().getYear(), now().getYear() + 40);

        return "%s/%s".formatted("%02d".formatted(month), year);
    }
}
