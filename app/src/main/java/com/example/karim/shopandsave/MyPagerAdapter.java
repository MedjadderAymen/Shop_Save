package com.example.karim.shopandsave;

import android.content.Context;
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    private Context ctx;
    public MyPagerAdapter(Context ctx, FragmentManager fm) {
        super(fm);
        this.ctx = ctx;
    }



    @Override

    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new Login();
            case 1:
                return new Inscription();
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Login";
            case 1:
                return "Inscription";
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
