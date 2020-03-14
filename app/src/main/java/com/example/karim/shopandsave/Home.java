package com.example.karim.shopandsave;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        SpaceNavigationView spaceNavigationView = (SpaceNavigationView) findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("settings", R.drawable.ic_settings_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("invalid list", R.drawable.ic_view_headline_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("valid list", R.drawable.ic_playlist_add_check_black_24dp  ));
        spaceNavigationView.addSpaceItem(new SpaceItem("profile", R.drawable.ic_person_black_24dp));
        spaceNavigationView.showIconOnly();
    }
}
