package com.example.praktikummp2.Praktikum2;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.praktikummp2.Praktikum2.Fragmen.FragmentFavorite;
import com.example.praktikummp2.Praktikum2.Fragmen.HomeFragment;
import com.example.praktikummp2.Praktikum2.Fragmen.ProfileFragment;
import com.example.praktikummp2.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import static android.content.ContentValues.TAG;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView BottomNav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        BottomNav = findViewById(R.id.bottom_nav);

        if (savedInstanceState == null){
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, homeFragment)
                    .commit();
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        BottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int i = item.getItemId();
                Fragment fragment = null;
                switch (i) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;

                    case R.id.favorite:
                        fragment = new FragmentFavorite();
                        break;
                    case R.id.profile:
                        fragment = new ProfileFragment();
                        break;
                }
                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.container, fragment)
                            .commit();

                } else {
                    Log.e(TAG, "Error in creating fragment");
                }
                return true;
            }



        });
    }
}