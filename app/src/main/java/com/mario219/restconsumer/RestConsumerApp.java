package com.mario219.restconsumer;

import android.app.Application;

import com.mario219.restconsumer.dependencyinjections.ApplicationComponent;
import com.mario219.restconsumer.dependencyinjections.ApplicationModule;
import com.mario219.restconsumer.dependencyinjections.DaggerApplicationComponent;
import com.mario219.restconsumer.dependencyinjections.RoomModule;
import com.mario219.restconsumer.utils.PreferencesManager;


/**
 * Created by mario219 on 10/12/17.
 */

public class RestConsumerApp extends Application {

    private ApplicationComponent applicationComponent;
    private static PreferencesManager preferencesManager = null;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(new ApplicationModule(this))
            .roomModule(new RoomModule(this))
            .build();

        preferencesManager.getInstance(this);
}

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    public static PreferencesManager getPreferencesManager(){
        return preferencesManager;
    }

}
