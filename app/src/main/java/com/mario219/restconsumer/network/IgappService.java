package com.mario219.restconsumer.network;

import java.util.List;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * Created by mario on 5/02/18.
 */


public interface IgappService {

    @GET("application/login/")
    Call<User> getUser(@Query("email") String email, @Query("password") String pass);

    @GET("sch/prospects.json")
    Observable<List<User>> getProspects(@Header("token") String token);

}
