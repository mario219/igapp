package com.mario219.restconsumer.utils;

/**
 * Created by marioalejndro on 20/07/17.
 */

public interface Preferences {

    String getCurrentSession();
    void SetCurrentSession (String token);
    Boolean databaseExits();
    void notifyDatabaseExits(Boolean flag);

}
