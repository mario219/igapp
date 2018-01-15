package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.presentation.view.contract.EditProspectView;
import com.mario219.restconsumer.network.listprospects.DataProspect;

/**
 * Created by marioalejndro on 30/06/17.
 */

public class EditDataProspectPresenter {

    private EditProspectView view;
    private DataProspect manageProspects;

    public EditDataProspectPresenter(EditProspectView view, DataProspect manageProspects) {

        this.view = view;
        this.manageProspects = manageProspects;

    }

    public void updateProspect(int id, String name, String surname, Long identification, Long tel) {
        manageProspects.updateProspect(id, name, surname, identification, tel);
        view.onUserUpdated();
    }

}
