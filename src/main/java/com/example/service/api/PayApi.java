package com.example.service.api;

import com.example.dto.request.OrderIdJson;
import com.example.dto.response.OrderStatusJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface PayApi {

    @POST("status")
    Call<OrderStatusJson> checkOrderStatus(@Header("merchant") String merchant,
                                           @Header("signature") String signature,
                                           @Body OrderIdJson orderId);
}
