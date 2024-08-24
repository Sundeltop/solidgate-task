package com.example.service;

import com.example.dto.request.PaymentPageDetails;
import com.example.dto.response.PaymentPageResult;
import com.example.service.api.PaymentApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import static com.example.config.ConfigManager.configuration;
import static com.example.utils.SignatureGenerator.generateSignature;
import static org.assertj.core.api.Assertions.assertThat;

public class PaymentService {

    private final PaymentApi api;
    private final ObjectMapper mapper;

    public PaymentService() {
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(configuration().apiPaymentPageEndpoint())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        mapper = new ObjectMapper();

        api = retrofit.create(PaymentApi.class);
    }

    @SneakyThrows
    public PaymentPageResult createPaymentPage(PaymentPageDetails paymentPageDetails) {
        final String merchant = configuration().publicKey();
        final String signature = generateSignature(
                merchant, mapper.writeValueAsString(paymentPageDetails), configuration().secretKey());

        final Response<PaymentPageResult> response =
                api.createPaymentPage(merchant, signature, paymentPageDetails).execute();

        assertThat(response.isSuccessful()).isTrue();

        return response.body();
    }
}
