package com.mario219.restconsumer.presentation.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.Connectivity;
import com.mario219.restconsumer.PreferencesManager;
import com.mario219.restconsumer.data.DataProspects;
import com.mario219.restconsumer.models.ProspectModel;
import com.mario219.restconsumer.presentation.presenter.ListProspectsPresenter;
import com.mario219.restconsumer.presentation.view.adapter.ProspectAdapter;
import com.mario219.restconsumer.presentation.view.contract.ListProspectsView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ListsProspectsFragment extends Fragment implements ListProspectsView{

    /**
     * UI
     */
    @BindView(R.id.prospects_recyclerview)
    RecyclerView recyclerView;
    @BindView(R.id.prospects_progressBar)
    ProgressBar progressBar;
    private Unbinder unbinder;

    /**
     * State
     */
    ListProspectsPresenter listProspectsPresenter;
    private Connectivity connectivity;

    public ListsProspectsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_prospects, container, false);
        unbinder = ButterKnife.bind(this, view);
        connectivity = new Connectivity(getContext());
        DataProspects dataInstance = DataProspects.getInstance(getContext());
        listProspectsPresenter = new ListProspectsPresenter(this, connectivity, dataInstance);
        listProspectsPresenter.loadProspectsList(new PreferencesManager(getContext()).getCurrentSession().toString());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * Contract methods
     */

    @Override
    public void onFailureConnection() {
        Toast.makeText(getContext(), R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadRecycler(List<ProspectModel> prospectList) {
        progressBar.setVisibility(View.GONE);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ProspectAdapter prospectAdapter = new ProspectAdapter(prospectList);
        recyclerView.setAdapter(prospectAdapter);
    }
}
