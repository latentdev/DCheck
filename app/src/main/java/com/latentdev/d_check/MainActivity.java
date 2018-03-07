package com.latentdev.d_check;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.latentdev.d_check.Fragments.CaliforniaAdventureFragment;
import com.latentdev.d_check.Fragments.DisneylandFragment;
import com.latentdev.d_check.Fragments.SettingsFragment;
import com.latentdev.d_check.Model.Rides;
import com.latentdev.d_check.Model.Settings;


public class MainActivity extends FragmentActivity implements DisneylandFragment.OnFragmentInteractionListener,SettingsFragment.OnFragmentInteractionListener, CaliforniaAdventureFragment.OnFragmentInteractionListener{

    Rides model;
    Settings settings;

    Fragment disneyland;
    Fragment californiaAdventure;
    Fragment settingsFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home: {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment, disneyland)
                            .commit();
                    return true;
                }
                case R.id.navigation_dashboard: {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment, californiaAdventure)
                            .commit();
                    return true;
                }
                case R.id.navigation_notifications: {
                    getFragmentManager().beginTransaction()
                            .replace(R.id.fragment,settingsFragment)
                            .commit();
                    return true;
                }
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getTitle());


        model = new Rides();
        model.Start();
        CreateFragments();



        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    @Override
    public void onPause()
    {
        super.onPause();
        model.Stop();
        DestroyFragments();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        model.Start();
        CreateFragments();
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        model.Stop();
        DestroyFragments();
    }

    public void CreateFragments()
    {
        disneyland = DisneylandFragment.newInstance(model);
        californiaAdventure = CaliforniaAdventureFragment.newInstance(model);
        settingsFragment = SettingsFragment.newInstance(settings);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment, disneyland)
                .commit();
    }

    public void DestroyFragments()
    {
        getFragmentManager().beginTransaction().remove(disneyland).commit();
        getFragmentManager().beginTransaction().remove(californiaAdventure).commit();
        getFragmentManager().beginTransaction().remove(settingsFragment).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
