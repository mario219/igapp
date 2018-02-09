package com.mario219.restconsumer.data.helper;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import com.mario219.restconsumer.data.dao.ProspectDao;
import com.mario219.restconsumer.data.databasemodels.ProspectDB;

/**
 * Created by mario219 on 7/12/17.
 */

@Database(entities = {ProspectDB.class}, version = 1, exportSchema = false)
public abstract class DataBaseHelper extends RoomDatabase {

    public abstract ProspectDao prospectDao();

}
