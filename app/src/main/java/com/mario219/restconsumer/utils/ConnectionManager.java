package com.mario219.restconsumer.utils;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by mario on 31/01/18.
 */

public class ConnectionManager implements LifecycleObserver {

    private static ConnectionManager INSTANCE;
    public static boolean ONLINE;

    private Context context;
    private ConnectionBroadCast connectionBroadCast;

    public ConnectionManager() {
    }

    public static synchronized ConnectionManager getInstance(){
        if(INSTANCE == null)
            INSTANCE = new ConnectionManager();
        return INSTANCE;
    }

    public void setOwner(LifecycleOwner lifecycleOwner, Context context) {
        this.context = context;
        connectionBroadCast = new ConnectionBroadCast();
        lifecycleOwner.getLifecycle().addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void registerReceiver(){
        context.registerReceiver(connectionBroadCast, new IntentFilter());
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void unregisterReceiver(){
        context.unregisterReceiver(connectionBroadCast);
    }

    private static class ConnectionBroadCast extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            android.net.ConnectivityManager cm = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            if(nInfo != null && nInfo.isConnectedOrConnecting()){
                ONLINE = true;
            }else{
                ONLINE = false;
            }
        }
    }

}
