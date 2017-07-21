package com.mario219.restconsumer.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class PreferencesManager implements Preferences {
    private static final String TAG = PreferencesManager.class.getSimpleName();
    private static String PREF_NAME = "CurrentSessionPref";
    private Context context;

    public PreferencesManager(Context context){
        this.context = context;
    }

    private SharedPreferences getPrefs (){
        return context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }

    /**
     *  Session Preferences
     */
    @Override
    public String getCurrentSession() {
        SharedPreferences prefs = getPrefs();
        String token = prefs.getString("token", "");
        if (!token.equals("")) {
            return token;
        }else{
            return null;
        }
    }

    @Override
    public void SetCurrentSession(String token) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("token", token);
        editor.commit();
        Log.i(TAG, "session updated");
    }

    /**
     *  Database Preferences
     */
    @Override
    public Boolean databaseExits() {
        SharedPreferences prefs = getPrefs();
        Boolean flag = prefs.getBoolean("flag", false);
        if (flag == true) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void notifyDatabaseExits(Boolean flag) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putBoolean("flag", flag);
        editor.commit();
        Log.i(TAG, "Saved database preference");
    }

}
