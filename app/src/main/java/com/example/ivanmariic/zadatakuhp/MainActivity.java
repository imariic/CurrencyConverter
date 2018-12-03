package com.example.ivanmariic.zadatakuhp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ivanmariic.zadatakuhp.Model.Currency;
import com.example.ivanmariic.zadatakuhp.Model.MyApi;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String BASE_URL = "http://hnbex.eu/api/v1/";
    private Spinner firstSpinner, secondSpinner;
    private Button submitButton;
    private TextView resultsTextView;
    private List<Currency> currencies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstSpinner = findViewById(R.id.spinner);
        secondSpinner = findViewById(R.id.spinner2);
        submitButton = findViewById(R.id.button);
        resultsTextView = findViewById(R.id.textView);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Currency Converter");


        Retrofit retorfit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();

        MyApi myApi = retorfit.create(MyApi.class);

        Call<List<Currency>> call = myApi.getCurrencies(Calendar.getInstance().getTime().toString());
        call.enqueue(new Callback<List<Currency>>() {
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
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double results;
                Currency currency1 = (Currency)firstSpinner.getSelectedItem();
                Currency currency2 = (Currency) secondSpinner.getSelectedItem();

                if(currency1.getCurrencyCode().equals(currency2.getCurrencyCode())){
                    results = 1.00;
                    resultsTextView.setText(String.valueOf(results));
                }else {

                    results = currency1.getBuyingRate() / currency2.getSellingRate();
                    resultsTextView.setText(String.valueOf(results));
                }

            }
        });
    }
}
