package com.example.ivanmariic.zadatakuhp.Model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyApi {
    @GET("rates/daily")
    Call<List<Currency>> getCurrencies(@Query("date") String date);
}
