package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.utils.PreferencesManager;
import com.mario219.restconsumer.presentation.view.contract.MainView;

/**
 * Created by marioalejndro on 30/06/17.
 */

public class MainPresenter {

    private MainView view;
    private PreferencesManager preferences;

    public MainPresenter(MainView view, PreferencesManager preferences) {
        this.view = view;
        this.preferences = preferences;
    }


    public void closeSession() {
        preferences.SetCurrentSession("");
        preferences.notifyDatabaseExits(false);
    }
}
