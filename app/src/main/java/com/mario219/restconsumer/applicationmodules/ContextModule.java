package com.mario219.restconsumer.applicationmodules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mario219 on 10/12/17.
 */

@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @RestConsumerScope
    @ApplicationContext
    public Context providesContext() {
        return context;
    }

}
