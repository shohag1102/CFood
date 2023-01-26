package com.saikat1102.cfood.customer_foodPanel;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.saikat1102.cfood.Cart;
import com.saikat1102.cfood.CartAdapter;
import com.saikat1102.cfood.DatabaseHelper;
import com.saikat1102.cfood.FoodOrdered;
import com.saikat1102.cfood.R;
import com.saikat1102.cfood.UpdateDishModel;

import java.util.ArrayList;
import java.util.List;


public class CustomerCartFragmnet extends Fragment {
    RecyclerView recyclerView;
    Button order_now_btn;
    AlertDialog.Builder builder;
    EditText address;
    TextView no_item_TV;
    public List<Cart> cartList;
    String total_price;
    public CartAdapter cartAdapter;
    DatabaseReference request;
    FirebaseDatabase database;
    DatabaseHelper databaseHelper;
    
    //other
    FirebaseAuth Fauth;
    StorageReference ref;
    FirebaseStorage storage;
    StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,dataa;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_customer_cart, null);
        getActivity().setTitle("Cart");

        no_item_TV = v.findViewById(R.id.no_item_TV);
        order_now_btn = v.findViewById(R.id.order_now_btn);
        databaseHelper = new DatabaseHelper(getContext());
        recyclerView = v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cartList = new ArrayList<>();
        cartAdapter = new CartAdapter(cartList);
        recyclerView.setAdapter(cartAdapter);
        builder = new AlertDialog.Builder(getContext());

        Cursor cursor = databaseHelper.show_data();
        while (cursor.moveToNext()){
            @SuppressLint("Range") String title= cursor.getString(cursor.getColumnIndex(databaseHelper.COL_FOOD_NAME));
            @SuppressLint("Range") String price = cursor.getString(cursor.getColumnIndex(databaseHelper.COL_PRICE));
            @SuppressLint("Range") String quantity = cursor.getString(cursor.getColumnIndex(databaseHelper.COL_QUANTITY));

            cartList.add(new Cart(title, price, quantity));
            cartAdapter.notifyDataSetChanged();
        }

        order_now_btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View view) {
                Cursor cursor1 = databaseHelper.total_price();
                while (cursor1.moveToNext()){
                    total_price = cursor1.getString(cursor1.getColumnIndex(DatabaseHelper.total_cost));
                }

                builder.setTitle("Total price : "+total_price+"Tk")
                        .setMessage("Enter your address : ");
                address = new EditText(getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
                address.setLayoutParams(lp);
                builder.setView(address);
                builder.setIcon(R.drawable.shopping_cart_24);

                builder.setPositiveButton("Yes", (dialogInterface, i) -> {
                    //Toast.makeText(getContext(), ""+total_price, Toast.LENGTH_SHORT).show();
                    //here firebase will work
                    Fauth = FirebaseAuth.getInstance();
                    String phone = Fauth.getCurrentUser().getPhoneNumber();

                    databaseReference = FirebaseDatabase.getInstance().getReference("FoodOrdered");

                    FoodOrdered foodOrdered = new FoodOrdered(phone, address.getText().toString(), cartList, total_price);

                    Toast.makeText(getContext(), "foodordered" + databaseReference, Toast.LENGTH_SHORT).show();
                    Log.e("databaseeeeeeeeee", phone);

                    //upload to firebase
                    databaseReference.child(Fauth.getCurrentUser().getUid())
                            .setValue(foodOrdered).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getContext(), "Food Uploaded Successfully", Toast.LENGTH_SHORT).show();
                                    databaseHelper.empty_cart();

                                    Log.e("listtttttt", cartList.get(0).getTitle().toString());
                                    cartAdapter.notifyDataSetChanged();
                                }
                            });
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                }).show();

            }
        });

        return v;
    }

}