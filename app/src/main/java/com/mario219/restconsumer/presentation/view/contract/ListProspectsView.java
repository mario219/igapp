package com.mario219.restconsumer.presentation.view.contract;

import com.mario219.restconsumer.data.databasemodels.ProspectDB;

import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public interface ListProspectsView {

    void onFailureConnection();
    void loadRecycler(List<ProspectDB> prospectList);

}
