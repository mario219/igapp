package com.mario219.restconsumer.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import javax.inject.Inject;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class PreferencesManager {

    private static final String TAG = PreferencesManager.class.getSimpleName();
    private SharedPreferences preferences;

    @Inject
    public PreferencesManager(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    /**
     *  Session Preferences
     */
    public String getCurrentSession() {
        String token = preferences.getString("token", "");
        if (!token.equals("")) {
            return token;
        }else{
            return null;
        }
    }

    public void SetCurrentSession(String token) {
        preferences.edit().putString("token", token);
    }

    /**
     *  Database Preferences
     */
    public Boolean databaseExits() {
        Boolean flag = preferences.getBoolean("flag", false);
        if (flag == true) {
            return true;
        }else{
            return false;
        }
    }

    public void notifyDatabaseExits(Boolean flag) {
        preferences.edit().putBoolean("flag", flag);
    }

}
