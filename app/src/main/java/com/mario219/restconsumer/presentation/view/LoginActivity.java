package com.mario219.restconsumer.presentation.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mario219.restconsumer.session.RestLogin;
import com.mario219.restconsumer.utils.ConnectivityManager;
import com.mario219.restconsumer.utils.PreferencesManager;
import com.mario219.restconsumer.R;
import com.mario219.restconsumer.presentation.presenter.LoginPresenter;
import com.mario219.restconsumer.presentation.view.contract.LoginView;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView{

    /**
     * UI
     */
    @BindView(R.id.login_et_email)
    EditText etEmail;
    @BindView(R.id.login_et_password)
    EditText etPassword;
    @BindView(R.id.login_progressBar)
    ProgressBar progressBar;

    /**
     * State
     */
    private LoginPresenter loginPresenter;
    private PreferencesManager preferenceManager;
    private ConnectivityManager connectivityManager;
    private RestLogin restLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        preferenceManager = new PreferencesManager(this);
        connectivityManager = new ConnectivityManager(this);
        restLogin = new RestLogin();
        loginPresenter = new LoginPresenter(this, preferenceManager, connectivityManager, restLogin);
    }

    @OnClick(R.id.login_btn_login)
    public void onClickLogin(){
        if(etEmail.getText().toString().equals("") || etPassword.getText().toString().equals("")){
            Toast.makeText(this, R.string.login_empty_field, Toast.LENGTH_SHORT).show();
        }else{
            progressBar.setVisibility(View.VISIBLE);
            loginPresenter.startLoginRequest(etEmail.getText().toString(), etPassword.getText().toString());
        }

    }


    /**
     * Contract methods
     */

    @Override
    public void login(String token) {
        progressBar.setVisibility(View.GONE);
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void loginFailure(String errorMessage) {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadCurrentSession() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }


}
