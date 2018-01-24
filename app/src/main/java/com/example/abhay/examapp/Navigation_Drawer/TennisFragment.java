package com.example.abhay.examapp.Navigation_Drawer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.abhay.examapp.R;


public class TennisFragment extends Fragment {

    Toolbar toolbar;

    public TennisFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_tennis, container, false);

        setupToolbar();
        return rootView;
    }


    void setupToolbar() {
        toolbar = getActivity().findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(R.drawable.a);
        toolbar.setTitle("Tennis");

    }


}

