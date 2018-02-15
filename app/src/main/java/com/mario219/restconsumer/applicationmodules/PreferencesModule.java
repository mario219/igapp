package com.mario219.restconsumer.applicationmodules;

import android.content.Context;
import android.content.SharedPreferences;

import com.mario219.restconsumer.utils.PreferencesManager;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by mario219 on 14/02/18.
 */

@Module(includes = ContextModule.class)
public class PreferencesModule {

    private static String PREF_NAME = "CurrentSessionPref";

    @Provides
    @RestConsumerScope
    public SharedPreferences sharedPreferences(@ApplicationContext Context context){
        return context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }

    @Provides
    @RestConsumerScope
    public PreferencesManager preferencesManager(SharedPreferences sharedPreferences){
        return new PreferencesManager(sharedPreferences);
    }

}
