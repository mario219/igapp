package com.mario219.restconsumer.session;

import android.content.Context;

import com.mario219.restconsumer.models.SessionErrorResponse;
import com.mario219.restconsumer.models.SessionModel;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by marioalejndro on 28/06/17.
 */

public class RestLogin implements Rest {

    private static final String url = "http://directotesting.igapps.co/";
    private static final String TAG = RestLogin.class.getSimpleName();
    private RestLoginCallback callback;

    public RestLogin() { }

    @Override
    public void setCallback(RestLoginCallback callback) {
        this.callback = callback;
    }

    @Override
    public void restLogin(String email, String password) {

        final Retrofit retrofit = new Retrofit.Builder()
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
                    Converter<ResponseBody, SessionErrorResponse> converter =
                            retrofit.responseBodyConverter(SessionErrorResponse.class, new Annotation[0]);
                    try {
                        SessionErrorResponse error;
                        error = converter.convert(response.errorBody());
                        callback.onFinishedRequestFailure(error.getError().toString());
                    } catch (IOException exc) {
                        callback.onFinishedRequestFailure(exc.toString());
                    }
                }

            }

            @Override
            public void onFailure(Call<SessionModel> call, Throwable t) {
                t.printStackTrace();
            }

        });

    }

}
