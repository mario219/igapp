package com.mario219.restconsumer.presentation.view.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.RestConsumerApp;
import com.mario219.restconsumer.models.User;
import com.mario219.restconsumer.presentation.viewmodel.UserViewModel;

import javax.inject.Inject;

public class LoginFragment extends Fragment {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    UserViewModel userViewModel;

    public LoginFragment() {
    }

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        userViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(UserViewModel.class);

        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {

            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((RestConsumerApp) getActivity().getApplication())
                .getApplicationComponent()
                .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return textView;
    }

}
