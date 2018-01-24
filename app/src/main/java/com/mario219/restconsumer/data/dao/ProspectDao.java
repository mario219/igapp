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

    @Query("select * from prospects")
    LiveData<List<ProspectDB>> getAllProspects();

    @Query("select * from prospects where identification like :identification")
    ProspectDB searchProspectWithId(Long identification);

    @Update
    void updateProspect(ProspectDB... prospectDB);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertProspect(ProspectDB... prospectDB);







}
