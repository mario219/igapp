package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.session.Rest;
import com.mario219.restconsumer.utils.Connectivity;
import com.mario219.restconsumer.utils.Preferences;
import com.mario219.restconsumer.presentation.view.contract.LoginView;
import com.mario219.restconsumer.session.RestLoginCallback;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class LoginPresenter implements RestLoginCallback {

    private LoginView view;
    private Preferences preferenceManager;
    private Connectivity connectivity;
    private Rest restLogin;
    private final String TAG = LoginPresenter.class.getSimpleName();

    public LoginPresenter(LoginView view, Preferences preferenceManager, Connectivity connectivity, Rest restLogin) {
        this.view = view;
        this.preferenceManager = preferenceManager;
        this.connectivity = connectivity;
        this.restLogin = restLogin;
        if(preferenceManager.getCurrentSession() != null) {
            view.loadCurrentSession();
        }
    }

    public void startLoginRequest(String email, String password){
        if(connectivity.isOnline()) {
            restLogin.restLogin(this, email, password);
        }else{
            onFinishedRequestFailure("You don´t have an internet connection");
        }
    }


    /**
     * Callback Methods
     */
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
