package com.mario219.restconsumer.prospects;

import com.mario219.restconsumer.models.ProspectModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by marioalejndro on 29/06/17.
 */

public interface Api {

    @GET("sch/prospects.json")
    Call<List<ProspectModel>> getProspects(@Header("token") String token);

}
