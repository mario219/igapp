package com.mario219.restconsumer.utils;

/**
 * Created by mario219 on 14/02/18.
 */

public interface Preferences {

    String getCurrentSession();
    void SetCurrentSession(String token);
    Boolean databaseExits();
    void notifyDatabaseExits(Boolean flag);

}
