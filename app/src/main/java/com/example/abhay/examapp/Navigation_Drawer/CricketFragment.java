package com.example.abhay.examapp.Navigation_Drawer;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abhay.examapp.R;


public class CricketFragment extends Fragment {

    android.support.v7.widget.Toolbar toolbar;

    public CricketFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_cricket, container, false);
        setupToolbar();
        return rootView;
    }


    void setupToolbar() {
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.a);
        toolbar.setTitle("Cricket");


    }

}

