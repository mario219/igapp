package com.mario219.restconsumer.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.mario219.restconsumer.data.databasemodels.ProspectDB;

import java.util.List;

/**
 * Created by mario219 on 6/12/17.
 */

@Dao
public interface ProspectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertProspect(ProspectDB... prospectDB);

    @Query("select * from prospects")
    public LiveData<List<ProspectDB>> getAllProspects();

    @Query("select * from prospects where identification like :identification")
    public LiveData<ProspectDB> searchProspectWithId(Long identification);

    @Update
    public void updateProspect(ProspectDB... prospectDB);

}
