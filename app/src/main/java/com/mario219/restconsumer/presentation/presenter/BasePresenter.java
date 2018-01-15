package com.mario219.restconsumer.presentation.presenter;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by mario219 on 12/08/17.
 */

public abstract class BasePresenter {

    Scheduler mainScheduler;
    CompositeDisposable subscriptionList = new CompositeDisposable();

    protected BasePresenter(Scheduler mainScheduler) {

        this.mainScheduler = mainScheduler;

    }

    public void onStart(){

    }

    public void onStop(){

        subscriptionList.dispose();

    }
}
