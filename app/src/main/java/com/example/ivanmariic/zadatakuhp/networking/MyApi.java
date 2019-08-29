package com.example.ivanmariic.zadatakuhp.networking;

import com.example.ivanmariic.zadatakuhp.model.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApi {

    @GET("rates/daily")
    Call<List<Currency>> getCurrencies(@Query("date") String date);
}
