package com.mario219.restconsumer.presentation.view.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario219 on 14/02/18.
 */

@Module
public class LoginFramentModule {

    private final LoginFragment loginFragment;

    public LoginFramentModule(LoginFragment loginFragment) {
        this.loginFragment = loginFragment;
    }

    @Provides
    @LoginActivityScope
    public LoginFragment loginActivity(){ return loginFragment; }

}
