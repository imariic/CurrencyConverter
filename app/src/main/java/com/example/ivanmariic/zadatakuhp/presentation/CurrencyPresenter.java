package com.example.ivanmariic.zadatakuhp.presentation;


import com.example.ivanmariic.zadatakuhp.contracts.CurrencyContract;
import com.example.ivanmariic.zadatakuhp.model.Currency;
import com.example.ivanmariic.zadatakuhp.networking.CurrencyInteractor;

import java.util.Calendar;
import java.util.List;
import retrofit2.Callback;

public class CurrencyPresenter implements CurrencyContract.Presenter {

    private CurrencyContract.CurrencyView currencyView;

    private CurrencyInteractor currencyInteractor;

    public CurrencyPresenter(CurrencyInteractor currencyInteractor){
        this.currencyInteractor = currencyInteractor;
    }

    @Override
    public void setView(CurrencyContract.CurrencyView view) {

        this.currencyView = view;
    }

    @Override
    public void calculateCurrencyXR(Currency firstCurrency, Currency secondCurrency) {

        double results;

        if(firstCurrency.getCurrencyCode().equals(secondCurrency.getCurrencyCode())){
            results = 1.00;
        }else {

            results = firstCurrency.getBuyingRate() / secondCurrency.getSellingRate();
        }

        currencyView.showResults(results);


    }

    @Override
    public void getCurrencies(Callback<List<Currency>> callback) {
        currencyInteractor.getCurrencies(Calendar.getInstance().getTime().toString(),callback);
    }
}
