package com.mario219.restconsumer.applicationmodules;

import android.content.SharedPreferences;

import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.network.IgappService;
import com.mario219.restconsumer.utils.Preferences;
import com.mario219.restconsumer.utils.PreferencesManager;

import dagger.Component;

/**
 * Created by mario219 on 10/12/17.
 */

@RestConsumerScope
@Component(modules = {IgappServiceModule.class, RoomModule.class, PreferencesModule.class})
public interface RestConsumerApplicationComponent {

    IgappService getIgappService();
    DataBaseHelper getDatabaseHelper();
    PreferencesManager getPreferences();

}
