package com.mario219.restconsumer.network.sessionlogin;

/**
 * Created by marioalejndro on 20/07/17.
 */

public interface Rest {

    void restLogin(RestLoginCallback callback, String email, String password);

}
