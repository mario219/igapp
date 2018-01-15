package com.mario219.restconsumer.network.listprospects;


import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marioalejndro on 29/06/17.
 */

public enum RequestProspectsUrl  {

    INSTANCE;

    private static final String url = "http://directotesting.igapps.co/";
    private final Api service;


    RequestProspectsUrl() {

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        service = retrofit.create(Api.class);

    }


    public Observable<List<ProspectModel>> getProspects(String token){

        return service.getProspects(token);

    }

}
