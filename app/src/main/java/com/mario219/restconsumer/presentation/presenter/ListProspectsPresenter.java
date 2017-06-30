package com.mario219.restconsumer.presentation.presenter;

import android.util.Log;

import com.mario219.restconsumer.Connectivity;
import com.mario219.restconsumer.PreferencesManager;
import com.mario219.restconsumer.data.DataProspects;
import com.mario219.restconsumer.models.ProspectModel;
import com.mario219.restconsumer.models.ProspectSqlModel;
import com.mario219.restconsumer.presentation.view.contract.ListProspectsView;
import com.mario219.restconsumer.prospects.ProspectManagerCallback;
import com.mario219.restconsumer.prospects.RequestProspects;
import com.mario219.restconsumer.prospects.RequestProspectsCallback;
import com.mario219.restconsumer.prospects.ProspectManager;

import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class ListProspectsPresenter implements RequestProspectsCallback, ProspectManagerCallback {

    private static final String TAG = ListProspectsPresenter.class.getSimpleName();

    private ListProspectsView view;
    private Connectivity connectivity;
    private PreferencesManager preferences;
    private RequestProspects restProspects;
    private ProspectManager manageProspects;

    public ListProspectsPresenter(
            ListProspectsView view,
            Connectivity connectivity,
            DataProspects dataInstance,
            PreferencesManager preferences) {

        this.view = view;
        this.connectivity = connectivity;
        this.preferences = preferences;
        restProspects = new RequestProspects(this);
        manageProspects = new ProspectManager(this, dataInstance);

    }

    public void loadProspectsList(String token) {
        if(preferences.databaseExits()){
            Log.i(TAG, "db exists!");
            manageProspects.loadCursorData();
        }else{
            if(connectivity.isOnline()){
                restProspects.requestProspects(token);
            }else{
                view.onFailureConnection();
            }
        }
    }

    @Override
    public void onRequestCompleted(List<ProspectModel> prospectList) {
        manageProspects.save(prospectList);
    }


    /**
     * Callback methods
     */
    @Override
    public void onDatabaseCreated(List<ProspectSqlModel> prospectSqlList) {
        preferences.notifyDatabaseExits(true);
        view.loadRecycler(prospectSqlList);
    }

    @Override
    public void onProspectUpdated(String message) {

    }
}
