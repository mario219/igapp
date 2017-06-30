package com.mario219.restconsumer.presentation.view;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mario219.restconsumer.PreferencesManager;
import com.mario219.restconsumer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * UI
     */
    @BindView(R.id.main_toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    /**
     * State
     */
    private PreferencesManager preferencesManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setLayout();
        preferencesManager = new PreferencesManager(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_list_prospects) {
            toolbar.setTitle(R.string.main_nav_title_prospects);
            ListsProspectsFragment prospectsFragment = new ListsProspectsFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, prospectsFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_logs) {
            toolbar.setTitle(R.string.main_nav_title_logs);
            LogFragment logFragment = new LogFragment();
            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, logFragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nav_close_session){
            preferencesManager.SetCurrentSession("");
            finish();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setLayout(){

        setSupportActionBar(toolbar);

        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        toolbar.setTitle("");
        //HomeFragment fragment = new HomeFragment();
        //fragmentTransaction.replace(R.id.fragment_container, fragment);
        //fragmentTransaction.commit();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }
}
