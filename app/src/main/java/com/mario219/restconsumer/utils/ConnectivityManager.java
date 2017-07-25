package com.mario219.restconsumer.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class ConnectivityManager extends BroadcastReceiver implements Connectivity {

    private Context context;

    public ConnectivityManager(Context context) {

        this.context = context;

    }

    public void onReceive(Context context, Intent intent) {
            android.net.ConnectivityManager cm = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            if(nInfo != null && nInfo.isConnectedOrConnecting()){
                Log.i("Network available", "flag1");
            }else{
                Log.i("Network lost", "flag2");
            }
    }


    @Override
    public Boolean isOnline() {
        android.net.ConnectivityManager cm = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo nInfo = cm.getActiveNetworkInfo();
        if(nInfo != null && nInfo.isConnectedOrConnecting()){
            return true;
        }else{
            return false;
        }
    }
}
