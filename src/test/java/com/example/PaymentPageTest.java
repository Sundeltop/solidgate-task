package com.example;

import com.example.dto.request.PaymentPageDetailsJson;
import com.example.dto.response.OrderStatusJson;
import com.example.dto.response.TransactionJson;
import com.example.service.PayService;
import com.example.service.PaymentService;
import com.example.testdata.TestDataStorage;
import com.example.web.pages.PaymentPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Currency;

import static com.codeborne.selenide.Selenide.open;
import static java.time.LocalDate.now;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentPageTest {

    private static final String VALID_CARD_NUMBER = "4067429974719265";
    private static final String EXPECTED_ORDER_SUCCESSFUL_STATUS = "success";

    private final PaymentService paymentService = new PaymentService();
    private final PayService payService = new PayService();
    private final TestDataStorage testDataStorage = new TestDataStorage();
    private final Faker faker = new Faker();

    @Test(description = "Verify Payment page is created and order is successfully payed")
    public void verifyPaymentPageIsCreatedAndOrderIsSuccessfullyPayed() {
        final PaymentPageDetailsJson paymentPageDetails = testDataStorage.generatePaymentPageDetails();

        final PaymentPage paymentPage = open(paymentService.createPaymentPage(paymentPageDetails).url(), PaymentPage.class);

        final String expectedCurrency = paymentPage.getCurrency();
        final String expectedAmount = paymentPage.getOrderAmount();

        paymentPage
                .setCardNumber(VALID_CARD_NUMBER)
                .setCardExpiry(getValidCardExpiry())
                .setCvc(faker.number().digits(3))
                .setNameOnCard(faker.name().fullName())
                .pay();

        final OrderStatusJson orderStatus = payService.checkOrderStatus(paymentPageDetails.getOrder().orderId());

        assertThat(orderStatus)
                .extracting(status -> status.transactions().getTransactions().getFirst())
                .returns(expectedCurrency, transaction -> Currency.getInstance(transaction.currency()).getSymbol())
                .returns(expectedAmount, transaction -> convertOrderAmount(transaction.amount()))
                .returns(EXPECTED_ORDER_SUCCESSFUL_STATUS, TransactionJson::status);
    }

    private String getValidCardExpiry() {
        final int month = faker.number().numberBetween(1, 12);
        final int year = faker.number().numberBetween(now().getYear(), now().getYear() + 40);

        return "%s/%s".formatted("%02d".formatted(month), year);
    }

    private String convertOrderAmount(int amount) {
        final String amountAsString = String.valueOf(amount);

        return "%s.%s".formatted(
                amountAsString.substring(0, amountAsString.length() - 2),
                amountAsString.substring(amountAsString.length() - 2)
        );
    }
}
