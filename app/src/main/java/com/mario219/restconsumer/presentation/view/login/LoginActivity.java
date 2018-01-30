package com.mario219.restconsumer.presentation.view.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;


import com.mario219.restconsumer.R;
import com.mario219.restconsumer.presentation.view.BaseActivity;

/**
 * Created by mario on 24/01/18.
 */

public class LoginActivity extends BaseActivity {
    private static final String LOGIN_FRAG = "LOGIN_FRAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager manager = getSupportFragmentManager();
        LoginFragment fragment = (LoginFragment) manager.findFragmentByTag(LOGIN_FRAG);

        if(fragment == null)
            fragment = LoginFragment.newInstance();
        addFragmentToActivity(manager, fragment, R.id.root_login_activity, LOGIN_FRAG);
    }
}
