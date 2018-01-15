package com.mario219.restconsumer.network.listprospects;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;

/**
 * Created by marioalejndro on 29/06/17.
 */

public interface Api {

    @GET("sch/prospects.json")
    Observable<List<ProspectModel>> getProspects(@Header("token") String token);

}
