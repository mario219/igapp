package com.mario219.restconsumer.presentation.view.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.RestConsumerApp;
import com.mario219.restconsumer.models.User;
import com.mario219.restconsumer.presentation.view.BaseFragment;
import com.mario219.restconsumer.presentation.viewmodel.UserViewModel;
import com.mario219.restconsumer.utils.ConnectionManager;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {

    /**
     * Injections
     */
    @Inject
    ViewModelProvider.Factory viewModelFactory;

    /**
     * Data
     */
    UserViewModel userViewModel;
    LoginFragmentListener listener;

    /**
     * UI
     */
    @BindView(R.id.et_login_email) EditText editTextLogin;
    @BindView(R.id.et_login_password) EditText editTextPassword;

    /**
     * Constructor
     */
    public LoginFragment() {
    }

    public static LoginFragment newInstance(){
        return new LoginFragment();
    }

    /**
     * Lifecycle
     */
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        userViewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(UserViewModel.class);

        userViewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                User user1 = user;
                editTextLogin.setText(user1.getName().toString());
            }
        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //((RestConsumerApp) getActivity().getApplication())
        //        .getApplicationComponent()
        //        .inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewLogin = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, viewLogin);
        return viewLogin;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (LoginFragmentListener) context;
        } catch (ClassCastException e) {
            throw new IllegalStateException("The hosting Activity must extend " + LoginFragmentListener.class.getName());
        }
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }

    /**
     * Events on UI
     */
    @OnClick(R.id.btn_login)
    public void onClickLogin(){
        if(editTextLogin.getText().toString().equals("") || editTextPassword.getText().toString().equals("")){
            Toast.makeText(getActivity(), R.string.blank_files, Toast.LENGTH_SHORT).show();
        }else{
            if(ConnectionManager.ONLINE) {
                showLoading();
                //RestLogin.getInstance().setCallback(this);
                //RestLogin.getInstance().restLogin(editTextLogin.getText().toString(), editTextPassword.getText().toString());
            }else{
                Toast.makeText(getActivity(), R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
            }
        }
    }

    /**
     * Callbacks
     */
    //@Override
    public void onLoginSuccess(String token) {
        hideLoading();
        //RestConsumerApp.getPreferencesManager().SetCurrentSession(token);
        listener.startMainActivity();
    }

    //@Override
    public void onLoginFailure(String error) {
        hideLoading();
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }

    public interface LoginFragmentListener{
        void startMainActivity();
    }

}
