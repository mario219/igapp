package com.mario219.restconsumer.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mario219.restconsumer.presentation.view.components.LoadingProgressBar;

import butterknife.Unbinder;


public class BaseFragment extends Fragment {

    protected Unbinder unbinder;
    public LoadingProgressBar progressBar;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        Context context = getContext();
        if(context != null){
            progressBar = new LoadingProgressBar(getContext());
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(unbinder != null) {
            unbinder.unbind();
        }
    }


    public void showLoading() {
        progressBar.show();
        progressBar.setCancelable(false);
    }

    public void hideLoading() {
        if (progressBar.isShowing())
            progressBar.dismiss();
    }

}
