package com.example.ivanmariic.zadatakuhp.ui.activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivanmariic.zadatakuhp.R;
import com.example.ivanmariic.zadatakuhp.contracts.CurrencyContract;
import com.example.ivanmariic.zadatakuhp.model.Currency;
import com.example.ivanmariic.zadatakuhp.networking.CurrencyInteractor;
import com.example.ivanmariic.zadatakuhp.networking.MyApi;
import com.example.ivanmariic.zadatakuhp.networking.NetworkingHelper;
import com.example.ivanmariic.zadatakuhp.presentation.CurrencyPresenter;
import com.example.ivanmariic.zadatakuhp.ui.adapters.SpinnerAdapter;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CurrencyContract.CurrencyView {

    private Spinner firstSpinner, secondSpinner;
    private Button submitButton;
    private TextView resultsTextView;
    private List<Currency> currencies;
    private CurrencyPresenter currencyPresenter = new CurrencyPresenter(new CurrencyInteractor());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUi();

        currencyPresenter.setView(this);

        currencyPresenter.getCurrencies(createCallback());

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Currency currency1 = (Currency)firstSpinner.getSelectedItem();
                Currency currency2 = (Currency) secondSpinner.getSelectedItem();

                currencyPresenter.calculateCurrencyXR(currency1,currency2);

            }
        });
    }

    private void setupUi(){
        firstSpinner = findViewById(R.id.spinner);
        secondSpinner = findViewById(R.id.spinner2);
        submitButton = findViewById(R.id.button);
        resultsTextView = findViewById(R.id.textView);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Currency Converter");
    }

    @Override
    public void showResults(double results) {
        resultsTextView.setText(String.valueOf(results));
    }

    public Callback<List<Currency>> createCallback(){

        return new Callback<List<Currency>>() {
            SpinnerAdapter adapter;
            Currency [] arrayOfCurrencies;
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
                currencies = response.body();
                arrayOfCurrencies = new Currency[currencies.size()];

                for(int i = 0; i < currencies.size(); i++){
                    arrayOfCurrencies[i] = currencies.get(i);
                }
                adapter = new SpinnerAdapter(MainActivity.this,android.R.layout.simple_spinner_item,arrayOfCurrencies);
                firstSpinner.setAdapter(adapter);
                secondSpinner.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Currency>> call, Throwable t) {
                Toast.makeText(MainActivity.this,"Epic fail!",Toast.LENGTH_LONG).show();
            }
        };
    }
}
