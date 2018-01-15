package com.mario219.restconsumer.network.listprospects;

import com.mario219.restconsumer.data.databasemodels.ProspectDB;

import java.util.List;

/**
 * Created by mario219 on 28/07/17.
 */

public interface DataProspect {

    void save(ProspectModel prospectModel);
    List<ProspectDB> loadCursorData();
    void updateProspect(int id, String name, String surname, Long identification, Long tel);
    void cleanDatabase();

}
