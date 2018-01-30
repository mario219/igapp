package com.mario219.restconsumer.presentation.view;

import android.support.v4.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.mario219.restconsumer.presentation.view.components.LoadingProgressBar;

/**
 * Created by mario on 24/01/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    public LoadingProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar = new LoadingProgressBar(this);
    }

    public static void addFragmentToActivity(android.support.v4.app.FragmentManager fragmentManager, Fragment fragment, int frameId, String tag) {
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.commit();
    }

    public void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();

            if (window == null) return;

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(color);
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


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
