package com.mario219.restconsumer.session;

import com.mario219.restconsumer.models.SessionModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by marioalejndro on 28/06/17.
 */

public interface Api {

    @GET("application/login/")
    Call<SessionModel> getUser(@Query ("email") String email, @Query("password") String pass);

    @GET("sch/prospects.json/")
    Call<List<Prospects>> getProspects(@Header("authToken") String token);


}
