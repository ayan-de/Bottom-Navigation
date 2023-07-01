package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
        bottomNavigation = (BottomNavigationView) findViewById(R.id.bottomNavigation);

        //setting up default
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new HomeFragment()).commit();

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
                } else if (itemId == R.id.settings) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new SettingFragment()).commit();
                } else if (itemId == R.id.messages) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new MessagesFragment()).commit();
                } else if (itemId == R.id.profile) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new ProfileFragment()).commit();
                }
                return true;
            }
        });

    }
}