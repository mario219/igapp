package com.mario219.restconsumer.prospects;

import com.mario219.restconsumer.models.ProspectSqlModel;

import java.util.List;

/**
 * Created by marioalejndro on 30/06/17.
 */

public interface ProspectManagerCallback {

    void onDatabaseCreated(List<ProspectSqlModel> prospectSqlList);

}
