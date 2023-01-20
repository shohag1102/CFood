package com.saikat1102.cfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.saikat1102.cfood.chefFoodPanel.ChefHomeFragment;
import com.saikat1102.cfood.customer_foodPanel.CustomerCartFragmnet;
import com.saikat1102.cfood.customer_foodPanel.CustomerHomeFragment;
import com.saikat1102.cfood.customer_foodPanel.CustomerOrdersFragment;
import com.saikat1102.cfood.customer_foodPanel.CustomerProfileFragment;
import com.saikat1102.cfood.customer_foodPanel.CustomerTrackFragment;

public class CustomerFoodPanel_BottomNavigation extends AppCompatActivity {

    BottomNavigationView bottom_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_food_panel_bottom_navigation);

        commence();

        String name = getIntent().getStringExtra("PAGE");

        if(name!=null){
            if(name.equalsIgnoreCase("Homepage")){
                replaceFragment(new CustomerHomeFragment());
            }
            else if(name.equalsIgnoreCase("Preparingpage")){
                replaceFragment(new CustomerTrackFragment());
            }
            else if(name.equalsIgnoreCase("DeliveryOrderpage")){
                replaceFragment(new CustomerTrackFragment());
            }
            else if(name.equalsIgnoreCase("Thankyoupage")){
                replaceFragment(new CustomerHomeFragment());
            }
        }
        else{
            replaceFragment(new CustomerHomeFragment());
        }


        implementBottomNavigation();
        replaceFragment(new CustomerHomeFragment());
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
    }

    private void implementBottomNavigation() {
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.cust_Home:
                        replaceFragment(new CustomerHomeFragment());
                        return true;
                    case R.id.cart:
                        replaceFragment(new CustomerCartFragmnet());
                        return true;
                    case R.id.Cust_order:
                        replaceFragment(new CustomerOrdersFragment());
                        return true;
                    case R.id.track:
                        replaceFragment(new CustomerTrackFragment());
                        return true;
                    case R.id.cust_profile:
                        replaceFragment(new CustomerProfileFragment());
                        return true;
                }

                return false;
            }
        });
    }

    private void commence() {
        bottom_navigation = findViewById(R.id.bottom_navigation);
    }
}