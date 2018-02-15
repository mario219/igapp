package com.mario219.restconsumer.presentation.view.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;


import com.mario219.restconsumer.R;
import com.mario219.restconsumer.RestConsumerApp;
import com.mario219.restconsumer.network.IgappService;
import com.mario219.restconsumer.presentation.view.BaseActivity;
import com.mario219.restconsumer.utils.PreferencesManager;

import javax.inject.Inject;

/**
 * Created by mario on 24/01/18.
 */

public class LoginActivity extends BaseActivity implements LoginFragment.LoginFragmentListener{
    private static final String LOGIN_FRAG = "LOGIN_FRAG";

    @Inject
    PreferencesManager preferences;

    @Inject
    IgappService igappService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        connectionManager.setOwner(this, this);

        LoginActivityComponent loginActivityComponent = DaggerLoginActivityComponent.builder()
                .loginActivityModule(new LoginActivityModule(this))
                .restConsumerApplicationComponent(RestConsumerApp.get(this).getApplicationComponent())
                .build();

        loginActivityComponent.injectLoginActivity(this);

        init();

    }

    private void init() {
        if (preferences.getCurrentSession() != null) {
            //startMainActivity();
            //this.finish();
            Log.i(LOGIN_FRAG, "Success " + preferences.getCurrentSession());
        } else {
            Log.i(LOGIN_FRAG, "Success, first time app login");
//            FragmentManager manager = getSupportFragmentManager();
//            LoginFragment fragment = (LoginFragment) manager.findFragmentByTag(LOGIN_FRAG);
//
//            if (fragment == null)
//                fragment = LoginFragment.newInstance();
//            addFragmentToActivity(manager, fragment, R.id.root_login_activity, LOGIN_FRAG);
        }
    }

    @Override
    public void startMainActivity() {
       // Intent intent = new Intent(this, MainActivity.class);

        this.finish();
    }

}
