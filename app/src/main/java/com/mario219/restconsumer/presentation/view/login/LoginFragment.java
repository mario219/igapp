package com.mario219.restconsumer.presentation.view.login;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.presentation.view.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragment extends BaseFragment {
    /**
     * Data
     */
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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
//        if(editTextLogin.getText().toString().equals("") || editTextPassword.getText().toString().equals("")){
//            Toast.makeText(getActivity(), R.string.blank_files, Toast.LENGTH_SHORT).show();
//        }else{
//            if(getContext().co) {
//                showLoading();
//            }else{
//                Toast.makeText(getActivity(), R.string.no_internet_connection, Toast.LENGTH_SHORT).show();
//            }
//        }
    }



    public interface LoginFragmentListener{
        void startMainActivity();
    }

}
