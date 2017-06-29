package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.presentation.view.contract.LoginView;
import com.mario219.restconsumer.session.RestLogin;
import com.mario219.restconsumer.session.SessionLoginCallback;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class LoginCallbackPresenter implements SessionLoginCallback {

    private LoginView view;
    private RestLogin restLogin;
    private final String TAG = LoginCallbackPresenter.class.getSimpleName();

    public LoginCallbackPresenter(LoginView view) {
        this.view = view;
        restLogin = new RestLogin(this);
    }

    public void startLoginRequest(String email, String password){
        restLogin.restLogin(email, password);
    }

    @Override
    public void onFinishedRequest(String email) {
        view.login(email);
    }
}
