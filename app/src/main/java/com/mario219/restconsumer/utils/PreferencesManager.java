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
    private static String PREF_NAME = "CurrentSessionPref";
    private final Context context;

    @Inject
    public PreferencesManager(Context context){
        this.context = context;
    }

    private SharedPreferences getPrefs (){
        return context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }

    /**
     *  Session Preferences
     */
    public String getCurrentSession() {
        SharedPreferences prefs = getPrefs();
        String token = prefs.getString("token", "");
        if (!token.equals("")) {
            return token;
        }else{
            return null;
        }
    }

    public void SetCurrentSession(String token) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("token", token);
        editor.commit();
        Log.i(TAG, "session updated");
    }

    /**
     *  Database Preferences
     */
    public Boolean databaseExits() {
        SharedPreferences prefs = getPrefs();
        Boolean flag = prefs.getBoolean("flag", false);
        if (flag == true) {
            return true;
        }else{
            return false;
        }
    }

    public void notifyDatabaseExits(Boolean flag) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putBoolean("flag", flag);
        editor.commit();
        Log.i(TAG, "Saved database preference");
    }

}
