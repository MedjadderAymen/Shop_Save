package com.example.karim.shopandsave;

import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class Main2Activity extends AppCompatActivity {
    ViewPager pagesVP;
    TabLayout slidingTL;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        getSupportActionBar().hide();

        pagesVP = findViewById(R.id.vpager);
        slidingTL   =findViewById(R.id.tablist);
        pagesVP.setAdapter(new MyPagerAdapter(getApplicationContext(),getSupportFragmentManager()));
        pagesVP.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(slidingTL));
        slidingTL.setupWithViewPager(pagesVP);



    }



    public void resetpass(View view) {
    }

    public void login(View view) {
    }
}
