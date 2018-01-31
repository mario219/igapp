package com.mario219.restconsumer.network.sessionlogin;

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

public class RestLogin{

    private static final String url = "http://directotesting.igapps.co/";
    private static final String TAG = RestLogin.class.getSimpleName();

    private static RestLogin INSTANCE;
    private RestLoginListener listener;


    private RestLogin() {
    }

    public static synchronized RestLogin getInstance() {
        if(INSTANCE == null)
            INSTANCE = new RestLogin();
        return INSTANCE;
    }

    public void setCallback(RestLoginListener listener1){
        this.listener = listener1;
    }

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
                    listener.onLoginSuccess(response.body().getAuthToken().toString());
                }catch (Exception e){
                    Converter<ResponseBody, ErrorResponseModel> converter =
                            retrofit.responseBodyConverter(ErrorResponseModel.class, new Annotation[0]);
                    try {
                        ErrorResponseModel error;
                        error = converter.convert(response.errorBody());
                        listener.onLoginFailure(error.getError().toString());
                    } catch (IOException exc) {
                        listener.onLoginFailure(exc.toString());
                    }
                }

            }

            @Override
            public void onFailure(Call<SessionModel> call, Throwable t) {
                t.printStackTrace();
            }

        });

    }

    public interface RestLoginListener {
        public void onLoginSuccess(String token);
        public void onLoginFailure(String error);
    }

}
