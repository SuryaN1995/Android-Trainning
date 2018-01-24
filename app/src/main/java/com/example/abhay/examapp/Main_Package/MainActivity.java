package com.example.abhay.examapp.Main_Package;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.abhay.examapp.Broadcast.BroadcastFragment;
import com.example.abhay.examapp.Database.SQL;
import com.example.abhay.examapp.Databinding.UserBindingFragment;
import com.example.abhay.examapp.FirebaseCloud.FirebaseFragment;
import com.example.abhay.examapp.Model.DataModel;
import com.example.abhay.examapp.Navigation_Drawer.CricketFragment;
import com.example.abhay.examapp.Navigation_Drawer.FootballFragment;
import com.example.abhay.examapp.Navigation_Drawer.HomeFragment;
import com.example.abhay.examapp.Navigation_Drawer.TennisFragment;
import com.example.abhay.examapp.Networking.JsonFragment;
import com.example.abhay.examapp.Networking.SchedulerFragment;
import com.example.abhay.examapp.Networking.WeatherFragment;
import com.example.abhay.examapp.R;
import com.example.abhay.examapp.Recycler_View.recycler;
import com.example.abhay.examapp.ServiceClass.ServiceFragment;
import com.example.abhay.examapp.Settings.SettingsFragment;
import com.example.abhay.examapp.Web.Web;


public class MainActivity extends AppCompatActivity implements SettingsFragment.OnFragmentInteractionListener, Web.OnFragmentInteractionListener, SQL.OnFragmentInteractionListener, recycler.OnFragmentInteractionListener, UserBindingFragment.OnFragmentInteractionListener, JsonFragment.OnFragmentInteractionListener, WeatherFragment.OnFragmentInteractionListener, SchedulerFragment.OnFragmentInteractionListener, BroadcastFragment.OnFragmentInteractionListener, ServiceFragment.OnFragmentInteractionListener, FirebaseFragment.OnFragmentInteractionListener {

    private static MainActivity mMainContext;
    Toolbar toolbar;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    public static MainActivity getmMainContext() {
        return mMainContext;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerList = findViewById(R.id.left_drawer);
        setupToolbar();


        DataModel[] drawerItem = new DataModel[15];
        drawerItem[0] = new DataModel(R.drawable.home, "HOME");
        drawerItem[1] = new DataModel(R.drawable.football, "FOOTBALL");
        drawerItem[2] = new DataModel(R.drawable.tennis, "TENNIS");
        drawerItem[3] = new DataModel(R.drawable.settings, "SETTINGS");
        drawerItem[4] = new DataModel(R.drawable.cricket, "CRICKET");
        drawerItem[5] = new DataModel(R.drawable.web, "WEB-VIEW");
        drawerItem[6] = new DataModel(R.drawable.sql, "SQL LITE");
        drawerItem[7] = new DataModel(R.drawable.recycler, "RECYCLER-VIEW");
        drawerItem[8] = new DataModel(R.drawable.data, "DATA-BINDING");
        drawerItem[9] = new DataModel(R.drawable.json, "JSON-PARSING");
        drawerItem[10] = new DataModel(R.drawable.weather, "WEATHER");
        drawerItem[11] = new DataModel(R.drawable.scheduler, "SCHEDULER");
        drawerItem[12] = new DataModel(R.drawable.broadcast, "BROADCAST");
        drawerItem[13] = new DataModel(R.drawable.service, "SERVICE_CLASS");
        drawerItem[14] = new DataModel(R.drawable.firebase1, "FIREBASE");


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);


        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        setupDrawerToggle();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }


    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new FootballFragment();
                break;
            case 2:
                fragment = new TennisFragment();
                break;

            case 3:
                fragment = new SettingsFragment();
                break;

            case 4:
                fragment = new CricketFragment();
                break;

            case 5:
                fragment = new Web();
                break;

            case 6:
                fragment = new SQL();
                break;

            case 7:
                fragment = new recycler();
                break;

            case 8:
                fragment = new UserBindingFragment();
                break;


            case 9:
                fragment = new JsonFragment();
                break;


            case 10:
                fragment = new WeatherFragment();
                break;

            case 11:
                fragment = new SchedulerFragment();
                break;

            case 12:
                fragment = new BroadcastFragment();
                break;

            case 13:
                fragment = new ServiceFragment();
                break;

            case 14:
                fragment = new FirebaseFragment();
                break;

            default:
                fragment = new HomeFragment();
                break;
        }


        if (fragment != null) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).addToBackStack(null).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.action_cricket:
                selectItem(0);
                break;


            case R.id.action_home:
                selectItem(4);
                break;


            case R.id.action_settings:
                selectItem(3);
                break;
        }


        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    void setupDrawerToggle() {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

}
