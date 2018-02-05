package com.mario219.restconsumer.dependencyinjections.applicationmodules;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

import com.mario219.restconsumer.data.dao.ProspectDao;
import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.data.repositories.ProspectRepository;
import com.mario219.restconsumer.presentation.viewmodel.CustomViewModelFactory;

/**
 * Created by mario219 on 10/12/17.
 */

@Module(includes = ContextModule.class)
public class RoomModule {

    private final DataBaseHelper dataBaseHelper;


    public RoomModule(@ApplicationContext Context context) {
        this.dataBaseHelper = Room.databaseBuilder(
                context,
                DataBaseHelper.class,
                "app_database.db"
        ).build();
    }

    @Provides
    @RestConsumerScope
    ProspectRepository provideProspectRepository(ProspectDao prospectDao){
        return new ProspectRepository(prospectDao);
    }

    @Provides
    @RestConsumerScope
    ProspectDao provideProspectDAO(DataBaseHelper dataBaseHelper){
        return dataBaseHelper.prospectDao();
    }

    @Provides
    @RestConsumerScope
    DataBaseHelper providesDataBase(Application application){
        return dataBaseHelper;
    }

    @Provides
    @RestConsumerScope
    ViewModelProvider.Factory provideViewModelFactory(ProspectRepository prospectRepository){
        return new CustomViewModelFactory(prospectRepository);
    }

}
