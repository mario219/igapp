package com.mario219.restconsumer.prospects;

import android.util.Log;

import com.mario219.restconsumer.data.DataProspects;
import com.mario219.restconsumer.models.ProspectModel;

import java.util.Iterator;
import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class SaveProspects {

    private static final String TAG = SaveProspects.class.getSimpleName();
    private DataProspects dataProspects;

    public SaveProspects(DataProspects dataProspects) {

        this.dataProspects = dataProspects;

    }

    public void save(List<ProspectModel> prospectList) {
        dataProspects.deleteDataBase();
        Iterator dataIterator = prospectList.iterator();

        while(dataIterator.hasNext()){
            ProspectModel obj = (ProspectModel) dataIterator.next();
            String name, surname;
            Long id, telephone;
            try {
                name = obj.getName();
            } catch (Exception e) {
                Log.i(TAG, " element NULL");
                name = "null";
            }

            try {
                surname = obj.getSurname();
            } catch (Exception e) {
                Log.i(TAG, " element NULL");
                surname = "null";
            }

            try {
                id = Long.parseLong(obj.getSchProspectIdentification());
            } catch (Exception e) {
                Log.i(TAG, " element NULL");
                id = null;
            }

            try {
                telephone = Long.parseLong(obj.getTelephone());
            } catch (Exception e) {
                Log.i(TAG, " element NULL");
                telephone = null;
            }
            Log.i(TAG, "nombre: " + name);
            dataProspects.saveProspect(name, surname, id, telephone);
        }
        dataProspects.close();
        //AlreadyDatabase.DbAlready(context, true);
        //loadView();
    }
}
