package com.mario219.restconsumer.applicationmodules;

import com.mario219.restconsumer.data.helper.DataBaseHelper;
import com.mario219.restconsumer.network.IgappService;

import dagger.Component;

/**
 * Created by mario219 on 10/12/17.
 */

@RestConsumerScope
@Component(modules = {IgappServiceModule.class, RoomModule.class})
public interface RestConsumerApplicationComponent {

    IgappService getIgappService();
    DataBaseHelper getDatabaseHelper();

}
