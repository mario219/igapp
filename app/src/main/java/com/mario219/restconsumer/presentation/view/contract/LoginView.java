package com.mario219.restconsumer.presentation.view.contract;

/**
 * Created by marioalejndro on 28/06/17.
 */

public interface LoginView {

    void login(String token);
    void loginFailure(String word);
    void loadCurrentSession();

}
