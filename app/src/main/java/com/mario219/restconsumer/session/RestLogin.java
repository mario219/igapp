package com.mario219.restconsumer.session;

import android.util.Log;

import com.mario219.restconsumer.models.SessionModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class RestLogin {

    private static final String url = "http://directotesting.igapps.co/";
    private static final String TAG = RestLogin.class.getSimpleName();
    private SessionLoginCallback callback;

    public RestLogin(SessionLoginCallback callback) {
        this.callback = callback;
    }

    public void restLogin(String email, String password){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api service = retrofit.create(Api.class);

        Call<SessionModel> call = service.getUser(email, password);
        call.enqueue(new Callback<SessionModel>(){

            @Override
            public void onResponse(Call<SessionModel> call, Response<SessionModel> response) {

                try {
                    callback.onFinishedRequest(response.body().getAuthToken().toString());
                }catch (Exception e){
                    Log.i(TAG, response.errorBody().toString());
                }

            }

            @Override
            public void onFailure(Call<SessionModel> call, Throwable t) {
                t.printStackTrace();
            }

        });
    }



}
