package com.mario219.restconsumer.presentation.view.login;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario219 on 14/02/18.
 */

@Module
public class LoginActivityModule {

    private final LoginActivity loginActivity;

    public LoginActivityModule(LoginActivity loginActivity) {
        this.loginActivity = loginActivity;
    }

    @Provides
    @LoginActivityScope
    public LoginActivity loginActivity(){ return loginActivity; }

}
