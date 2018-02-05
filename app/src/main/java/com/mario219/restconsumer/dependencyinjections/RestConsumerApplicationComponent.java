package com.mario219.restconsumer.dependencyinjections;

import android.app.Application;

import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.dependencyinjections.applicationmodules.ContextModule;
import com.mario219.restconsumer.dependencyinjections.applicationmodules.IgappServiceModule;
import com.mario219.restconsumer.dependencyinjections.applicationmodules.RestConsumerScope;
import com.mario219.restconsumer.dependencyinjections.applicationmodules.RoomModule;
import com.mario219.restconsumer.network.IgappService;
import com.mario219.restconsumer.presentation.view.login.LoginFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mario219 on 10/12/17.
 */

@RestConsumerScope
@Component(modules = {IgappServiceModule.class, RoomModule.class})
public interface RestConsumerApplicationComponent {

    IgappService getIgappService();
    DataBaseHelper getDatabaseHelper();

}
