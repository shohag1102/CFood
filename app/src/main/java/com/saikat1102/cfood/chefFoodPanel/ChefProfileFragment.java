package com.saikat1102.cfood.chefFoodPanel;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.saikat1102.cfood.R;


public class ChefProfileFragment extends Fragment {

    Button post_dish;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chef_profile,null);
        getActivity().setTitle("Post Dish");

        commence(v);
        post_dish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),chef_postDish.class));
            }
        });

        return v;
    }

    private void commence(View v) {
        post_dish = v.findViewById(R.id.post_dish);
    }


}