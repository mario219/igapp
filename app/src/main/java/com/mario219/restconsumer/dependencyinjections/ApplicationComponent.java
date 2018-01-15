package com.mario219.restconsumer.dependencyinjections;

import android.app.Application;

import com.mario219.restconsumer.presentation.view.EditProspectActivity;
import com.mario219.restconsumer.presentation.view.ListsProspectsFragment;
import com.mario219.restconsumer.presentation.view.LoginActivity;
import com.mario219.restconsumer.presentation.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mario219 on 10/12/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity loginActivity);
    void inject(MainActivity mainActivity);
    void inject(ListsProspectsFragment listsProspectsFragment);
    void inject(EditProspectActivity editProspectActivity);

    Application application();


}
