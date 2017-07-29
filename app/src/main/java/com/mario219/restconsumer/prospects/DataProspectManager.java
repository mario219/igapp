package com.mario219.restconsumer.prospects;

import android.database.Cursor;
import android.util.Log;

import com.mario219.restconsumer.data.SQLDataProspectsHelper;
import com.mario219.restconsumer.models.ProspectModel;
import com.mario219.restconsumer.models.ProspectSqlModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class DataProspectManager implements DataProspect{

    private static final String TAG = DataProspectManager.class.getSimpleName();
    private SQLDataProspectsHelper SQLDataProspectsHelper;

    public DataProspectManager(SQLDataProspectsHelper SQLDataProspectsHelper) {

        this.SQLDataProspectsHelper = SQLDataProspectsHelper;

    }

    @Override
    public void save(DataProspectManagerCallback callback1, List<ProspectModel> prospectList) {

        DataProspectManagerCallback callback = callback1;

        SQLDataProspectsHelper.deleteDataBase();
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
            SQLDataProspectsHelper.saveProspect(name, surname, id, telephone);
        }
        SQLDataProspectsHelper.close();
        callback.onSaveCompleted();
    }

    @Override
    public void loadCursorData(DataProspectManagerCallback callback) {

        Cursor cursor = SQLDataProspectsHelper.getAllProspects();
        if(cursor.getCount() == 0){
            Log.i(TAG, "Cursor is empty");
            SQLDataProspectsHelper.close();
            return;
        }
        List<ProspectSqlModel> prospectList = new ArrayList<>();
        while(cursor.moveToNext()){
            ProspectSqlModel object = new ProspectSqlModel();
            object.setId(cursor.getInt(0));
            object.setName(cursor.getString(1));
            object.setSurname(cursor.getString(2));
            object.setIdentification(cursor.getLong(3));
            object.setTelephone(cursor.getLong(4));
            prospectList.add(object);
        }
        SQLDataProspectsHelper.close();
        callback.onDatabaseCreated(prospectList);
    }

    @Override
    public void updateProspect(DataProspectManagerCallback callback1, int id, String name, String surname, Long identification, Long tel){

        DataProspectManagerCallback callback  = callback1;

        SQLDataProspectsHelper.updateProspect(id, name, surname, identification, tel);
        callback.onProspectUpdated("User updated!");

    }
}
