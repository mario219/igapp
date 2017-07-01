package com.mario219.restconsumer.presentation.presenter;

import android.util.Log;

import com.mario219.restconsumer.Connectivity;
import com.mario219.restconsumer.PreferencesManager;
import com.mario219.restconsumer.R;
import com.mario219.restconsumer.presentation.view.contract.LoginView;
import com.mario219.restconsumer.session.RestLogin;
import com.mario219.restconsumer.session.RestLoginCallback;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class LoginPresenter implements RestLoginCallback {

    private LoginView view;
    private PreferencesManager preferenceManager;
    private Connectivity connectivity;
    private RestLogin restLogin;
    private final String TAG = LoginPresenter.class.getSimpleName();

    public LoginPresenter(LoginView view, PreferencesManager preferenceManager, Connectivity connectivity) {
        this.view = view;
        this.preferenceManager = preferenceManager;
        this.connectivity = connectivity;
        restLogin = new RestLogin(this);
        if(preferenceManager.getCurrentSession() != null) {
            view.loadCurrentSession();
        }
    }

    public void startLoginRequest(String email, String password){
        if(connectivity.isOnline()) {
            restLogin.restLogin(email, password);
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
