package com.example.karim.shopandsave;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Inscription extends Fragment {
    public Inscription(){  }
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView=inflater.inflate(R.layout.fragment_iscription, container, false);



        return rootView;
    }
    }



