package com.saikat1102.cfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.saikat1102.cfood.chefFoodPanel.ChefHomeFragment;
import com.saikat1102.cfood.chefFoodPanel.ChefOrderFragment;
import com.saikat1102.cfood.chefFoodPanel.ChefPendingOrderFragment;
import com.saikat1102.cfood.chefFoodPanel.ChefProfileFragment;

public class ChefFoodPanel_BottomNavigation extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_food_panel_bottom_navigation);
        commence();

        implementBottomNavigation();
        replaceFragment(new ChefHomeFragment());

    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
    }

    private void implementBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.chefHome:
                        replaceFragment(new ChefHomeFragment());
                        return true;
                    case R.id.PendingOrders:
                        replaceFragment(new ChefPendingOrderFragment());
                        return true;
                    case R.id.Orders:
                        replaceFragment(new ChefOrderFragment());
                        return true;
                    case R.id.chefProfile:
                        replaceFragment(new ChefProfileFragment());
                        return true;
                }

                return false;
            }
        });
    }


    private void commence() {
        bottomNavigationView = findViewById(R.id.chef_bottom_navigation);
    }
}