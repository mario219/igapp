package com.mario219.restconsumer;

import android.app.Activity;
import android.app.Application;

import com.mario219.restconsumer.dependencyinjections.RestConsumerApplicationComponent;
import com.mario219.restconsumer.dependencyinjections.applicationmodules.ContextModule;
import com.mario219.restconsumer.utils.PreferencesManager;


/**
 * Created by mario219 on 10/12/17.
 */

public class RestConsumerApp extends Application {

    private RestConsumerApplicationComponent restConsumerApplicationComponent;

    public static RestConsumerApp get(Activity activity){
        return (RestConsumerApp) activity.getApplication();
    }


    @Override
    public void onCreate() {
        super.onCreate();

        restConsumerApplicationComponent = DaggerRestConsumerApplicationComponent.builder()
                .contexModule(new ContextModule(this))
                .build();


    }

    public RestConsumerApplicationComponent getRestConsumerApplicationComponent(){
        return restConsumerApplicationComponent;
    }

    public static PreferencesManager getPreferencesManager(){
        return null;
    }

}
