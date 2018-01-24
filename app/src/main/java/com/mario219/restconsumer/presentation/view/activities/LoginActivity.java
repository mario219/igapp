package com.mario219.restconsumer.presentation.view.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;


import com.mario219.restconsumer.R;
import com.mario219.restconsumer.presentation.view.fragments.LoginFragment;

/**
 * Created by mario on 24/01/18.
 */

public class LoginActivity extends BaseActivity {
    private static final String LOGIN_FRAG = "LOGIN_FRAG";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        FragmentManager manager = getFragmentManager();
        LoginFragment fragment = (LoginFragment) manager.findFragmentByTag(LOGIN_FRAG);

        if(fragment == null)
            fragment = LoginFragment.newInstance();
        addFragmentToActivity(manager, fragment, R.id.action_settings, LOGIN_FRAG);
    }
}
