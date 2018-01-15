package com.mario219.restconsumer.presentation.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.data.databasemodels.ProspectDB;
import com.mario219.restconsumer.network.listprospects.DataProspectManager;
import com.mario219.restconsumer.utils.PreferencesManager;
import com.mario219.restconsumer.presentation.presenter.ListProspectsPresenter;
import com.mario219.restconsumer.presentation.view.adapter.ProspectAdapter;
import com.mario219.restconsumer.presentation.view.contract.ListProspectsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ListsProspectsFragment extends Fragment implements ListProspectsView {

    /**
     * UI
     */
    @BindView(R.id.prospects_swipeRefreshLayout) SwipeRefreshLayout mSwipeRefreshLayout;
    @BindView(R.id.prospects_recyclerview) RecyclerView recyclerView;
    @BindView(R.id.prospects_progressBar) ProgressBar progressBar;
    private Unbinder unbinder;

    /**
     * State
     */
    private ListProspectsPresenter listProspectsPresenter;
    private PreferencesManager preferencesManager;
    private DataProspectManager dataProspectManager;

    public ListsProspectsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prospects, container, false);
        unbinder = ButterKnife.bind(this, view);

        preferencesManager = new PreferencesManager(getContext());
        //SQLDataProspectsHelper dataInstance = SQLDataProspectsHelper.getInstance(getContext());
        //dataProspectManager = new DataProspectManager(dataInstance);

        //Load Layout
        listProspectsPresenter = new ListProspectsPresenter(this, preferencesManager,
                AndroidSchedulers.mainThread(), dataProspectManager);
        listProspectsPresenter.loadProspectsList();

        //Refresh Layout
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listProspectsPresenter.loadProspectsList();
            }
        });

        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        listProspectsPresenter.onStop();
    }


    /**
     * Contract methods
     */
    @Override
    public void onFailureConnection() {
        Toast.makeText(getContext(), R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void loadRecycler(List<ProspectDB> prospectList) {

        mSwipeRefreshLayout.setRefreshing(false);
        progressBar.setVisibility(View.GONE);
        /*
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ProspectAdapter prospectAdapter = new ProspectAdapter(prospectList);
        recyclerView.setAdapter(prospectAdapter);
        */
    }

}
