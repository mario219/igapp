package com.mario219.restconsumer.prospects;

import com.mario219.restconsumer.models.ProspectModel;

import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public interface RestProspectsCallback {

    void onRequestCompleted(List<ProspectModel> prospectList);

}
