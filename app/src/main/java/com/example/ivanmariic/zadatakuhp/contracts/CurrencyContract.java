package com.example.ivanmariic.zadatakuhp.contracts;

import com.example.ivanmariic.zadatakuhp.model.Currency;

import java.util.List;

import retrofit2.Callback;

public interface CurrencyContract {

    interface CurrencyView{
        void showResults(double results);
    }

    interface Presenter{

        void setView(CurrencyView view);
        void calculateCurrencyXR(Currency firstCurrency, Currency secondCurrency);
        void getCurrencies(Callback<List<Currency>> callback);
    }

}
