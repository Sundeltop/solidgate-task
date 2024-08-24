package com.example.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public abstract class BaseService {

    protected final Retrofit retrofit;
    protected final ObjectMapper mapper;

    public BaseService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(url())
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        mapper = new ObjectMapper();
    }

    protected abstract String url();
}
