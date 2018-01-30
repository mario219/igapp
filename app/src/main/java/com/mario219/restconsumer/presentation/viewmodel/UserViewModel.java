package com.mario219.restconsumer.presentation.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.mario219.restconsumer.models.User;

/**
 * Created by mario on 30/01/18.
 */

public class UserViewModel extends ViewModel {

    private MutableLiveData<User> user;

    public MutableLiveData getUser() {
        if(user == null)
            user = new MutableLiveData<User>();
        return user;
    }

    public void setUser(MutableLiveData user) {
        this.user = user;
    }

}
