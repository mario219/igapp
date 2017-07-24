package com.mario219.restconsumer.session;

/**
 * Created by marioalejndro on 20/07/17.
 */

public interface Rest {

    void setCallback(RestLoginCallback callback);
    void restLogin(String email, String password);
    void restLoginSuccessful(String token);
    void restLoginFailure(String message);

}
