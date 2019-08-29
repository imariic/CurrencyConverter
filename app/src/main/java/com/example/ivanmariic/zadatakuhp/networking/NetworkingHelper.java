package com.example.ivanmariic.zadatakuhp.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkingHelper {

    private static final String BASE_URL = "http://hnbex.eu/api/v1/";

    private static NetworkingHelper instance = null;

    public static NetworkingHelper getInstance(){
        if(instance == null){
            return new NetworkingHelper();
        } else {
            return instance;
        }
    }

    private Retrofit initializeRetrofit(){

        return new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
    }

    public  MyApi initializeApiService(){
        return initializeRetrofit().create(MyApi.class);
    }
}
