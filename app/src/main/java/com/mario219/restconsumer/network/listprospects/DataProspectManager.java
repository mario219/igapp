package com.mario219.restconsumer.network.listprospects;

import android.arch.lifecycle.LiveData;
import android.util.Log;

import com.mario219.restconsumer.data.databasemodels.ProspectDB;
import com.mario219.restconsumer.data.helper.DataBaseHelper;

import java.util.Collections;
import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class DataProspectManager implements DataProspect{

    private static final String TAG = DataProspectManager.class.getSimpleName();
    //private SQLDataProspectsHelper sqlDataProspectHelper;
    private DataBaseHelper dataBaseHelper;

    public DataProspectManager(DataBaseHelper dataBaseHelper) {

        this.dataBaseHelper = dataBaseHelper;

    }

    @Override
    public void save(ProspectModel prospectModel) {

        String name, surname;
        Long id, telephone;
        try {
            name = prospectModel.getName();
        } catch (Exception e) {
            Log.i(TAG, " element NULL");
            name = "null";
        }

        try {
            surname = prospectModel.getSurname();
        } catch (Exception e) {
            Log.i(TAG, " element NULL");
            surname = "null";
        }

        try {
            id = Long.parseLong(prospectModel.getSchProspectIdentification());
        } catch (Exception e) {
            Log.i(TAG, " element NULL");
            id = null;
        }

        try {
            telephone = Long.parseLong(prospectModel.getTelephone());
        } catch (Exception e) {
            Log.i(TAG, " element NULL");
            telephone = null;
        }

        dataBaseHelper.prospectDao().insertProspect(new ProspectDB(name, surname, id, telephone));

    }

    @Override
    public List<ProspectDB> loadCursorData() {

        //LiveData<List<ProspectDB>> prospectDBList = dataBaseHelper.prospectDao().getAll();

        return Collections.EMPTY_LIST;

    }

    @Override
    public void updateProspect(int id, String name, String surname, Long identification, Long tel){
        //sqlDataProspectHelper.updateProspect(id, name, surname, identification, tel);
        //sqlDataProspectHelper.close();
    }

    @Override
    public void cleanDatabase() {
        //sqlDataProspectHelper.deleteDataBase();
    }
}
