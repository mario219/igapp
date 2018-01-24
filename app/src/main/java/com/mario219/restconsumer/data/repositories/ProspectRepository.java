package com.mario219.restconsumer.data.repositories;

import android.arch.lifecycle.LiveData;

import com.mario219.restconsumer.data.dao.ProspectDao;
import com.mario219.restconsumer.data.databasemodels.ProspectDB;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mario219 on 10/12/17.
 */

public class ProspectRepository {

    private final ProspectDao prospectDao;

    @Inject
    public ProspectRepository(ProspectDao prospectDao) {
        this.prospectDao = prospectDao;
    }

    public LiveData<List<ProspectDB>> getAllProspects(){
        return prospectDao.getAllProspects();
    }

    public ProspectDB searchProspectWithId(Long identification){
        return prospectDao.searchProspectWithId(identification);
    }

    public void updateProspect(ProspectDB prospectDB){
        prospectDao.updateProspect(prospectDB);
    }

    public Long insertProspect(ProspectDB prospectDB){
        return prospectDao.insertProspect(prospectDB);
    }
}
