package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.data.DataProspects;
import com.mario219.restconsumer.models.ProspectSqlModel;
import com.mario219.restconsumer.presentation.view.contract.EditProspectView;
import com.mario219.restconsumer.prospects.ProspectManager;
import com.mario219.restconsumer.prospects.ProspectManagerCallback;

import java.util.List;

/**
 * Created by marioalejndro on 30/06/17.
 */

public class EditProspectPresenter implements ProspectManagerCallback{

    private EditProspectView view;
    private ProspectManager manageProspects;

    public EditProspectPresenter(EditProspectView view, DataProspects dataInstance) {

        this.view = view;
        manageProspects = new ProspectManager(this, dataInstance);

    }

    public void updateProspect(int id, String name, String surname, Long identification, Long tel) {
        manageProspects.updateProspect(id, name, surname, identification, tel);
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
}
