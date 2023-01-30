package com.saikat1102.cfood.customer_foodPanel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saikat1102.cfood.MainMenu;
import com.saikat1102.cfood.R;


public class CustomerProfileFragment extends Fragment {
    TextView name, phone;
    Button logout;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    String phoneNumber = mAuth.getCurrentUser().getPhoneNumber();
    String email = mAuth.getCurrentUser().getEmail();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_customer_profile, null);
        getActivity().setTitle("Profile");

        commence(v);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getContext(), MainMenu.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });

        phone.setText(phoneNumber);
        name.setText(email);
        return v;
    }

    private void commence(View v) {
        name = v.findViewById(R.id.name);
        phone = v.findViewById(R.id.phone);
        logout = v.findViewById(R.id.logout);
    }


}