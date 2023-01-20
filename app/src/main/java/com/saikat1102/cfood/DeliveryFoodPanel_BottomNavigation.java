package com.saikat1102.cfood;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.saikat1102.cfood.chefFoodPanel.ChefHomeFragment;
import com.saikat1102.cfood.chefFoodPanel.ChefOrderFragment;
import com.saikat1102.cfood.chefFoodPanel.ChefPendingOrderFragment;
import com.saikat1102.cfood.deliveryFoodPanel.DeliveryPendingOrderFragment;
import com.saikat1102.cfood.deliveryFoodPanel.DeliveryShipOrderFragment;

public class DeliveryFoodPanel_BottomNavigation extends AppCompatActivity {
    BottomNavigationView delivery_bottom_navigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_food_panel_bottom_navigation);

        delivery_bottom_navigation = findViewById(R.id.delivery_bottom_navigation);

        String name = getIntent().getStringExtra("PAGE");

        if(name!=null){
            if(name.equalsIgnoreCase("DeliveryOrderpage")){
                replaceFragment(new DeliveryPendingOrderFragment());
            }
        }
        else{
            replaceFragment(new DeliveryPendingOrderFragment());
        }

        implementBottomNavigation();
        replaceFragment(new DeliveryShipOrderFragment());


    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
    }

    private void implementBottomNavigation() {
        delivery_bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.shiporders:
                        replaceFragment(new DeliveryShipOrderFragment());
                        break;
                    case R.id.pendingorders:
                        replaceFragment(new DeliveryPendingOrderFragment());
                        break;
                }

                return false;
            }
        });
    }
}