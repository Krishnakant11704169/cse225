package com.example.dynamicfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Symptoms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);
        BottomNavigationView bottomNavigationView = findViewById(R.id.symptomsBottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.home:
                            selectedFragment = new coughFragment();
                            break;
                        case R.id.favorite:
                            selectedFragment = new feverFragment();
                            break;
                        case R.id.search:
                            selectedFragment = new breathingFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.dynamicFragmentContainer, selectedFragment).commit();
                    return true;
                }
            };
}
