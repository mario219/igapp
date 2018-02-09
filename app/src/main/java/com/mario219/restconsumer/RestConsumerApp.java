package com.mario219.restconsumer;

import android.app.Activity;
import android.app.Application;

import com.mario219.restconsumer.applicationmodules.DaggerRestConsumerApplicationComponent;
import com.mario219.restconsumer.applicationmodules.RestConsumerApplicationComponent;
import com.mario219.restconsumer.applicationmodules.ContextModule;
import com.mario219.restconsumer.applicationmodules.RoomModule;
import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.network.IgappService;

import timber.log.Timber;


/**
 * Created by mario219 on 10/12/17.
 */

public class RestConsumerApp extends Application {

    private RestConsumerApplicationComponent applicationComponent;

    public static RestConsumerApp get(Activity activity){
        return (RestConsumerApp) activity.getApplication();
    }

    private IgappService igappService;
    private DataBaseHelper dataBaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        applicationComponent = DaggerRestConsumerApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();

        igappService = applicationComponent.getIgappService();
        dataBaseHelper = applicationComponent.getDatabaseHelper();

    }

    public RestConsumerApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }


}
