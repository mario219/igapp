package com.mario219.restconsumer.presentation.presenter;

import android.util.Log;

import com.mario219.restconsumer.prospects.DataProspect;
import com.mario219.restconsumer.prospects.RequestProspects;
import com.mario219.restconsumer.utils.Connectivity;
import com.mario219.restconsumer.utils.ConnectivityManager;
import com.mario219.restconsumer.utils.Preferences;
import com.mario219.restconsumer.utils.PreferencesManager;
import com.mario219.restconsumer.data.SQLDataProspectsHelper;
import com.mario219.restconsumer.models.ProspectModel;
import com.mario219.restconsumer.models.ProspectSqlModel;
import com.mario219.restconsumer.presentation.view.contract.ListProspectsView;
import com.mario219.restconsumer.prospects.DataProspectManagerCallback;
import com.mario219.restconsumer.prospects.RequestProspectsUrlCallback;
import com.mario219.restconsumer.prospects.DataProspectManager;

import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class ListProspectsPresenter implements RequestProspectsUrlCallback, DataProspectManagerCallback {

    private static final String TAG = ListProspectsPresenter.class.getSimpleName();

    private ListProspectsView view;
    private Connectivity connectivityManager;
    private Preferences preferences;
    private RequestProspects requestProspects;
    private DataProspect dataProspectManager;

    public ListProspectsPresenter(
            ListProspectsView view,
            Connectivity connectivityManager,
            Preferences preferences,
            RequestProspects requestProspects,
            DataProspect dataProspectManager) {

        this.view = view;
        this.connectivityManager = connectivityManager;
        this.preferences = preferences;
        this.requestProspects = requestProspects;
        this.dataProspectManager = dataProspectManager;

    }

    public void loadProspectsList(String token) {

        if(preferences.databaseExits()){
            dataProspectManager.loadCursorData(this);
        }else{
            if(connectivityManager.isOnline()){
                requestProspects.requestProspects(this, token);
            }else{
                view.onFailureConnection();
            }
        }

    }


    /**
     * Callback methods
     */
    @Override
    public void onRequestCompleted(List<ProspectModel> prospectList) {
        dataProspectManager.save(this, prospectList);
    }

    @Override
    public void onRequestFail(String error) {
        view.displayErrorMessage(error);
    }

    @Override
    public void onSaveCompleted() {
        dataProspectManager.loadCursorData(this);
    }

    @Override
    public void onDatabaseCreated(List<ProspectSqlModel> prospectSqlList) {
        preferences.notifyDatabaseExits(true);
        view.loadRecycler(prospectSqlList);
    }

    @Override
    public void onProspectUpdated(String message) {

    }

}
