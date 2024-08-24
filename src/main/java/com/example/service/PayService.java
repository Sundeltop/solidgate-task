package com.example.service;

import com.example.dto.request.OrderIdJson;
import com.example.service.api.PayApi;
import lombok.SneakyThrows;
import retrofit2.Response;

import static com.example.config.ConfigManager.configuration;
import static com.example.utils.SignatureGenerator.generateSignature;
import static org.assertj.core.api.Assertions.assertThat;

public class PayService extends BaseService {

    private final PayApi api = retrofit.create(PayApi.class);

    @Override
    protected String url() {
        return configuration().apiPayEndpoint();
    }

    @SneakyThrows
    public void checkOrderStatus(OrderIdJson orderId) {
        final String merchant = configuration().publicKey();
        final String signature = generateSignature(
                merchant, mapper.writeValueAsString(orderId), configuration().secretKey());

        Response<Void> response = api.checkOrderStatus(merchant, signature, orderId).execute();

        assertThat(response.isSuccessful()).isTrue();
    }
}
