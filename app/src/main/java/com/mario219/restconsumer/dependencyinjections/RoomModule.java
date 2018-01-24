package com.mario219.restconsumer.dependencyinjections;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import com.mario219.restconsumer.data.dao.ProspectDao;
import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.data.repositories.ProspectRepository;
import com.mario219.restconsumer.presentation.viewmodel.CustomViewModelFactory;

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
                application,
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

    @Provides
    @Singleton
    ViewModelProvider.Factory provideViewModelFactory(ProspectRepository prospectRepository){
        return new CustomViewModelFactory(prospectRepository);
    }


}
