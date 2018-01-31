package com.mario219.restconsumer.presentation.presenter;

import com.mario219.restconsumer.network.listprospects.DataProspect;
import com.mario219.restconsumer.network.listprospects.RequestProspectsUrl;
import com.mario219.restconsumer.presentation.view.contract.ListProspectsView;

import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.Observable;

/**
 * Created by marioalejndro on 29/06/17.
 */

public class ListProspectsPresenter extends BasePresenter {

    private static final String TAG = ListProspectsPresenter.class.getSimpleName();

    private ListProspectsView view;
    private Preferences preferences;
    private DataProspect dataProspectManager;

    public ListProspectsPresenter(ListProspectsView view, Preferences preferences,
                                  Scheduler mainScheduler, DataProspect dataProspectManager) {

        super(mainScheduler);
        this.view = view;
        this.preferences = preferences;
        this.dataProspectManager = dataProspectManager;

    }

    public void loadProspectsList() {

        if (!preferences.getCurrentSession().isEmpty()){
            view.loadRecycler(dataProspectManager.loadCursorData());
        } else {
            loadReactiveProspectList();
        }
    }

    private void loadReactiveProspectList() {

        Disposable subscription = RequestProspectsUrl.INSTANCE.getProspects(preferences.getCurrentSession())
                .subscribeOn(Schedulers.io())
                .flatMap(Observable::fromIterable)
                .distinct()
                .observeOn(Schedulers.computation())
                //.doOnNext(prospectModel -> dataProspectManager.save(prospectModel))
                .subscribe(prospectModel -> {
                            dataProspectManager.save(prospectModel);
                        },
                        error -> {
                            if (error instanceof UnknownHostException || error instanceof SocketTimeoutException)
                                view.onFailureConnection();
                        },
                        () -> view.loadRecycler(dataProspectManager.loadCursorData()));
        subscriptionList.add(subscription);

    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
