package com.saikat1102.cfood.chefFoodPanel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.saikat1102.cfood.Order;
import com.saikat1102.cfood.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ChefOrderFragment extends Fragment {
    FirebaseDatabase firebaseDatabase;
    RecyclerView recyclerView;
    TextView address_student, phone_student, foods_student, total_price_student;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference1;
    DatabaseReference databaseReference2;
    DatabaseReference databaseReference3;
    FirebaseAuth firebaseAuth;
    String currentUser;
    String phone,total_price;
    String address = "";
    Order order;
    String food="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_chef_orders,null);
        address_student = v.findViewById(R.id.address_student);
        phone_student = v.findViewById(R.id.phone_student);
        foods_student = v.findViewById(R.id.foods_student);
        total_price_student = v.findViewById(R.id.total_price_student);

        getActivity().setTitle("New Orders");

        //currentUser = String.valueOf(FirebaseDatabase.getInstance().getReference("FoodOrdered").child(String.valueOf(FirebaseAuth.getInstance().getCurrentUser())));
        //System.out.println(firebaseAuth.getCurrentUser().toString());

        databaseReference = FirebaseDatabase.getInstance().getReference("FoodOrdered").child("XvVAhY5vWPWb7UuPRjMtOEryTdD3").child("address");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("FoodOrdered").child("XvVAhY5vWPWb7UuPRjMtOEryTdD3").child("phone_number");
        databaseReference2 = FirebaseDatabase.getInstance().getReference("FoodOrdered").child("XvVAhY5vWPWb7UuPRjMtOEryTdD3").child("total_price");
        databaseReference3 = FirebaseDatabase.getInstance().getReference("FoodOrdered").child("XvVAhY5vWPWb7UuPRjMtOEryTdD3").child("foods");

        //address
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                address = snapshot.getValue().toString();
                address_student.setText("Address : "+address);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //phone number
        databaseReference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                phone = snapshot.getValue().toString();
                phone_student.setText("Phone Number : "+phone);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //total price
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                total_price = snapshot.getValue().toString();
                total_price_student.setText("Total : "+total_price +" Tk");

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        //foods
        databaseReference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                System.out.println(snapshot.getValue().toString());
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    String quantity, price, title;
                    quantity = dataSnapshot.child("quantity").getValue().toString();
                    price = dataSnapshot.child("price").getValue().toString();
                    title = dataSnapshot.child("title").getValue().toString();

                    food += title+" ( "+price+" tk * "+quantity+" )"+"\n";
                     order = new Order(address, phone, total_price, food);
                }
                foods_student.setText("Order : "+food);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        return v;
    }
}