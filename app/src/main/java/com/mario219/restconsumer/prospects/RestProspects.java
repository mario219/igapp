package com.mario219.restconsumer.prospects;


import android.util.Log;

import com.mario219.restconsumer.models.ProspectModel;
import com.mario219.restconsumer.models.SessionErrorResponse;
import com.mario219.restconsumer.models.SessionModel;
import com.mario219.restconsumer.session.*;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class RestProspects {

    private static final String url = "http://directotesting.igapps.co/";
    private static final String TAG = RestProspects.class.getSimpleName();
    private final RestProspectsCallback callback;

    public RestProspects(RestProspectsCallback callback) {
        this.callback = callback;
    }

    public void requestProspects(String token){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api service = retrofit.create(Api.class);

        Call<List<ProspectModel>> call = service.getProspects(token);
        call.enqueue(new Callback<List<ProspectModel>>(){

            @Override
            public void onResponse(Call<List<ProspectModel>> call, Response<List<ProspectModel>> response) {
                try{
                    callback.onRequestCompleted(response.body());
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<ProspectModel>> call, Throwable t) {

            }
        });
    }
}
