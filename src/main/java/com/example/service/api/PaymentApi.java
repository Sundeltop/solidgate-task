package com.example.service.api;

import com.example.dto.request.PaymentPageDetailsJson;
import com.example.dto.response.PaymentPageResultJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PaymentApi {

    @POST("init")
    Call<PaymentPageResultJson> createPaymentPage(@Header("merchant") String merchant,
                                                  @Header("signature") String signature,
                                                  @Body PaymentPageDetailsJson paymentPageDetails);
}
