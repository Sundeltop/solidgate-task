package com.example.service;

import com.example.dto.request.PaymentPageDetailsJson;
import com.example.dto.response.PaymentPageResultJson;
import com.example.service.api.PaymentApi;
import lombok.SneakyThrows;
import retrofit2.Response;

import static com.example.config.ConfigManager.configuration;
import static com.example.utils.SignatureGenerator.generateSignature;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentService extends BaseService {

    private final PaymentApi api = retrofit.create(PaymentApi.class);

    @Override
    protected String url() {
        return configuration().apiPaymentPageEndpoint();
    }

    @SneakyThrows
    public PaymentPageResultJson createPaymentPage(PaymentPageDetailsJson paymentPageDetails) {
        final String merchant = configuration().publicKey();
        final String signature = generateSignature(
                merchant, mapper.writeValueAsString(paymentPageDetails), configuration().secretKey());

        final Response<PaymentPageResultJson> response =
                api.createPaymentPage(merchant, signature, paymentPageDetails).execute();

        assertThat(response.isSuccessful()).isTrue();

        return response.body();
    }
}
