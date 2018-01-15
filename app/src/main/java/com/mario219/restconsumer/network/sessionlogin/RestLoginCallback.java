package com.mario219.restconsumer.network.sessionlogin;

/**
 * Created by marioalejndro on 28/06/17.
 */

public interface RestLoginCallback {

    void onFinishedRequest(String token);
    void onFinishedRequestFailure(String errorMessage);

}
