package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.PreferencesManager;
import com.mario219.restconsumer.presentation.view.contract.LoginView;
import com.mario219.restconsumer.session.RestLogin;
import com.mario219.restconsumer.session.RestLoginCallback;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class LoginPresenter implements RestLoginCallback {

    private LoginView view;
    private PreferencesManager preferenceManager;
    private RestLogin restLogin;
    private final String TAG = LoginPresenter.class.getSimpleName();

    public LoginPresenter(LoginView view, PreferencesManager preferenceManager) {
        this.view = view;
        this.preferenceManager = preferenceManager;
        restLogin = new RestLogin(this);
        if(preferenceManager.getCurrentSession() != null) {
            view.loadCurrentSession();
        }
    }

    public void startLoginRequest(String email, String password){
        restLogin.restLogin(email, password);
    }

    @Override
    public void onFinishedRequest(String token) {
        preferenceManager.SetCurrentSession(token);
        view.login(token);
    }

    @Override
    public void onFinishedRequestFailure(String errorMessage) {
        view.loginFailure(errorMessage);
    }
}
