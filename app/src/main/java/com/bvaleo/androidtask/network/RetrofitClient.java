package com.bvaleo.androidtask.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Valery on 13.12.2017.
 */

public class RetrofitClient {
    private static Retrofit mClient = null;

    public static Retrofit getClient(String baseUrl){
        if (mClient == null) {
            mClient = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mClient;
    }

}
