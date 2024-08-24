package com.example.service.api;

import com.example.dto.request.PaymentPageDetails;
import com.example.dto.response.PaymentPageResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PaymentApi {

    @POST("init")
    Call<PaymentPageResult> createPaymentPage(@Header("merchant") String merchant,
                                              @Header("signature") String signature,
                                              @Body PaymentPageDetails paymentPageDetails);
}
