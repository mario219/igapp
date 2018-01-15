package com.mario219.restconsumer.network.sessionlogin;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by marioalejndro on 28/06/17.
 */

public interface Api {

    @GET("application/login/")
    Call<SessionModel> getUser(@Query ("email") String email, @Query("password") String pass);

}
