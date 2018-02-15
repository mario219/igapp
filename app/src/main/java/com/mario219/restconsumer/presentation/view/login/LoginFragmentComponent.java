package com.mario219.restconsumer.presentation.view.login;

import com.mario219.restconsumer.applicationmodules.RestConsumerApplicationComponent;

import dagger.Component;

/**
 * Created by mario219 on 14/02/18.
 */

@Component(modules = LoginFramentModule.class, dependencies = RestConsumerApplicationComponent.class)
@LoginActivityScope
public interface LoginFragmentComponent {

    void injectLoginActivity(LoginFragment loginActivity);

}
