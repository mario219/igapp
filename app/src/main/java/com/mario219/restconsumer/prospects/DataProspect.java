package com.mario219.restconsumer.prospects;

import com.mario219.restconsumer.models.ProspectModel;

import java.util.List;

/**
 * Created by mario219 on 28/07/17.
 */

public interface DataProspect {

    void save(DataProspectManagerCallback callback, List<ProspectModel> prospectList);
    void loadCursorData(DataProspectManagerCallback callback);
    void updateProspect(DataProspectManagerCallback callback, int id, String name, String surname, Long identification, Long tel);

}
