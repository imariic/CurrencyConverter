package com.example.ivanmariic.zadatakuhp.networking;

import com.example.ivanmariic.zadatakuhp.model.Currency;

import java.util.Date;
import java.util.List;

import retrofit2.Callback;

public class CurrencyInteractor {

    private MyApi currencyApi;

    public CurrencyInteractor() {
       currencyApi =  NetworkingHelper.getInstance().initializeApiService();
    }

    public void getCurrencies(String date, Callback<List<Currency>> callback){
        currencyApi.getCurrencies(date).enqueue(callback);
    }
}
