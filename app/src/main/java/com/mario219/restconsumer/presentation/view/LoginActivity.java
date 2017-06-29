package com.mario219.restconsumer.presentation.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.mario219.restconsumer.R;
import com.mario219.restconsumer.presentation.presenter.LoginCallbackPresenter;
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

    /**
     * State
     */
    private LoginCallbackPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginCallbackPresenter(this);
    }

    @OnClick(R.id.login_btn_login)
    public void onClickLogin(){
        if(etEmail.getText().toString().equals("") || etPassword.getText().toString().equals("")){
            Toast.makeText(this, R.string.login_empty_field, Toast.LENGTH_SHORT).show();
        }else{
            loginPresenter.startLoginRequest(etEmail.getText().toString(), etPassword.getText().toString());
        }
    }


    /**
     * Contract methods
     */

    @Override
    public void login(String word) {
        Toast.makeText(this, word, Toast.LENGTH_SHORT).show();
    }


}
