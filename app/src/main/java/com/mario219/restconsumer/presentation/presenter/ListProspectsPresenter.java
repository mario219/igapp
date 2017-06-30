package com.mario219.restconsumer.presentation.presenter;

import android.util.Log;

import com.mario219.restconsumer.Connectivity;
import com.mario219.restconsumer.data.DataProspects;
import com.mario219.restconsumer.models.ProspectModel;
import com.mario219.restconsumer.presentation.view.contract.ListProspectsView;
import com.mario219.restconsumer.prospects.RestProspects;
import com.mario219.restconsumer.prospects.RestProspectsCallback;
import com.mario219.restconsumer.prospects.SaveProspects;

import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class ListProspectsPresenter implements RestProspectsCallback{

    private static final String TAG = ListProspectsPresenter.class.getSimpleName();
    private ListProspectsView view;
    private Connectivity connectivity;
    private DataProspects dataInstance;
    private RestProspects restProspects;
    private SaveProspects saveProspects;

    public ListProspectsPresenter(ListProspectsView view, Connectivity connectivity, DataProspects dataInstance) {

        this.view = view;
        this.connectivity = connectivity;
        this.dataInstance = dataInstance;
        restProspects = new RestProspects(this);

    }

    public void loadProspectsList(String token) {
        if(connectivity.isOnline()){
                restProspects.requestProspects(token);
        }else{
            view.onFailureConnection();
        }
    }


    @Override
    public void onRequestCompleted(List<ProspectModel> prospectList) {
        saveProspects = new SaveProspects(dataInstance);
        saveProspects.save(prospectList);
        view.loadRecycler(prospectList);
    }
}
