package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.data.SQLDataProspectsHelper;
import com.mario219.restconsumer.models.ProspectSqlModel;
import com.mario219.restconsumer.presentation.view.contract.EditProspectView;
import com.mario219.restconsumer.prospects.DataProspect;
import com.mario219.restconsumer.prospects.DataProspectManager;
import com.mario219.restconsumer.prospects.DataProspectManagerCallback;

import java.util.List;

/**
 * Created by marioalejndro on 30/06/17.
 */

public class EditDataProspectPresenter implements DataProspectManagerCallback {

    private EditProspectView view;
    private DataProspect manageProspects;

    public EditDataProspectPresenter(EditProspectView view, DataProspect manageProspects) {

        this.view = view;
        this.manageProspects = manageProspects;

    }

    public void updateProspect(int id, String name, String surname, Long identification, Long tel) {
        manageProspects.updateProspect(this, id, name, surname, identification, tel);
    }

    /**
     * Callback methods
     */
    @Override
    public void onDatabaseCreated(List<ProspectSqlModel> prospectSqlList) {

    }

    @Override
    public void onProspectUpdated(String message) {
        view.onUserUpdated(message);
    }

    @Override
    public void onSaveCompleted() {

    }
}
