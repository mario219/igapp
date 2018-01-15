package com.mario219.restconsumer.dependencyinjections;

import android.app.Application;
import android.arch.persistence.room.Room;
import com.mario219.restconsumer.data.dao.ProspectDao;
import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.data.repositories.ProspectRepository;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by mario219 on 10/12/17.
 */

@Module
public class RoomModule {

    private final DataBaseHelper dataBaseHelper;


    public RoomModule(Application application) {
        this.dataBaseHelper = Room.databaseBuilder(
                application.getApplicationContext(),
                DataBaseHelper.class,
                "app_database.db"
        ).build();
    }

    @Provides
    @Singleton
    ProspectRepository provideProspectRepository(ProspectDao prospectDao){
        return new ProspectRepository(prospectDao);
    }

    @Provides
    @Singleton
    ProspectDao provideProspectDAO(DataBaseHelper dataBaseHelper){
        return dataBaseHelper.prospectDao();
    }

    @Provides
    @Singleton
    DataBaseHelper providesDataBase(Application application){
        return dataBaseHelper;
    }


}
