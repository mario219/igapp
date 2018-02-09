package com.mario219.restconsumer.applicationmodules;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.presentation.viewmodel.CustomViewModelFactory;

/**
 * Created by mario219 on 10/12/17.
 */

@Module(includes = ContextModule.class)
public class RoomModule {

    @Provides
    @RestConsumerScope
    public DataBaseHelper dataBaseHelper (@ApplicationContext Context context) {
        return Room.databaseBuilder(
                context,
                DataBaseHelper.class,
                "app_database.db"
        ).build();
    }

    /*@Provides
    @RestConsumerScope
    ViewModelProvider.Factory viewModelFactory(ProspectRepository prospectRepository){
        return new CustomViewModelFactory(prospectRepository);
    }*/

}
