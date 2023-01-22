package com.saikat1102.cfood.chefFoodPanel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saikat1102.cfood.MainMenu;
import com.saikat1102.cfood.R;
import com.saikat1102.cfood.UpdateDishModel;
import com.saikat1102.cfood.customer_foodPanel.Customer;
import com.saikat1102.cfood.customer_foodPanel.CustomerHomeAdapter;

import java.util.ArrayList;
import java.util.List;


public class ChefHomeFragment extends Fragment {

    RecyclerView recyclerView;
    public List<UpdateDishModel> updateDishModelList;
    public CustomerHomeAdapter adapter;
    DatabaseReference dataa,databaseReference;
    SwipeRefreshLayout swipeRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_chef_home,null);

        recyclerView = v.findViewById(R.id.recyclerView);

        getActivity().setTitle("Home");
        setHasOptionsMenu(true);



        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        updateDishModelList = new ArrayList<>();

                String  userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                dataa = FirebaseDatabase.getInstance().getReference("Customer").child(userid);

                Log.e("Customerrrrrrrrrrr", dataa.getKey().toString());

                dataa.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        Customer custo = snapshot.getValue(Customer.class);

                        customermenu();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

        return v;
    }

    private void customermenu() {
        databaseReference = FirebaseDatabase.getInstance().getReference("FoodDetails");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                updateDishModelList.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){

                    Log.e("FoodDetailssssssssssss", snapshot1.getKey().toString());

                        for(DataSnapshot snapshot2 : snapshot1.getChildren()){
                            UpdateDishModel updateDishModel = snapshot2.getValue(UpdateDishModel.class);
                            updateDishModelList.add(updateDishModel);
                        }


                }

                adapter = new CustomerHomeAdapter(getContext(),updateDishModelList);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.logout, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.LOGOUT){
            logout();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(getContext(), MainMenu.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}