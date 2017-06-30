package com.mario219.restconsumer;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by marioalejndro on 28/06/17.
 */

public class PreferencesManager {
    private static final String TAG = PreferencesManager.class.getSimpleName();
    private static String PREF_NAME = "CurrentSessionPref";
    private Context context;

    public PreferencesManager(Context context){
        this.context = context;
    }

    private SharedPreferences getPrefs (){
        return context.getSharedPreferences(PREF_NAME, MODE_PRIVATE);
    }

    public String getCurrentSession(){
        SharedPreferences prefs = getPrefs();
        String token = prefs.getString("token", "");
        if (!token.equals("")) {
            return token;
        }else{
            return null;
        }
    }

    public void SetCurrentSession (String token) {
        SharedPreferences.Editor editor = getPrefs().edit();
        editor.putString("token", token);
        editor.commit();
        Log.i(TAG, "session updated");
    }



}
