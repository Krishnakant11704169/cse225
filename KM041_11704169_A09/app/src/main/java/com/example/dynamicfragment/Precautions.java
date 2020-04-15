package com.example.dynamicfragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Precautions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precautions);

        BottomNavigationView bottomNavigationView = findViewById(R.id.precautionsBottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlistener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()) {
                        case R.id.stayhome:
                            selectedFragment = new stayhomeFragmnet();
                            break;
                        case R.id.mask:
                            selectedFragment = new maskFragment();
                            break;
                        case R.id.washhands:
                            selectedFragment = new washhandFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.dynamicPreFragmentContainer, selectedFragment).commit();
                    return true;
                }
            };
}
