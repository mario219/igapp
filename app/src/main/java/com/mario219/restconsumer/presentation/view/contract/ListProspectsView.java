package com.mario219.restconsumer.presentation.view.contract;

import com.mario219.restconsumer.models.ProspectModel;

import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public interface ListProspectsView {

    void onFailureConnection();
    void loadRecycler(List<ProspectModel> prospectList);
}
