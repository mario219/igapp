package com.mario219.restconsumer.prospects;


import com.mario219.restconsumer.models.ProspectModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class RequestProspects {

    private static final String url = "http://directotesting.igapps.co/";
    private static final String TAG = RequestProspects.class.getSimpleName();
    private final RequestProspectsCallback callback;

    public RequestProspects(RequestProspectsCallback callback) {
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
