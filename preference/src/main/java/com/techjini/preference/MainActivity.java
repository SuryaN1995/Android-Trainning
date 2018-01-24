package com.techjini.preference;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SettingsFragment.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                getFragmentManager().beginTransaction()
                        .replace(R.id.contentc, new SettingsFragment())
                        .commit();
            }

    @Override
    public void onFragmentInteraction(Uri uri)
    {

    }
}
