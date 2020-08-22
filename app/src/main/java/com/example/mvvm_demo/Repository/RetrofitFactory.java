package com.example.mvvm_demo.Repository;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 就是Retroit的封装
 */

public class RetrofitFactory {
    private static Retrofit retrofit;
    private static OkHttpClient client;
    private static final String Host="https://api.uomg.com/";
    static {
        client=new OkHttpClient.Builder()
                .connectTimeout(9, TimeUnit.SECONDS)
                .build();
        retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Host)
                .build();
    }

    public static  Retrofit getInstance(){
        return retrofit;
    }

}
