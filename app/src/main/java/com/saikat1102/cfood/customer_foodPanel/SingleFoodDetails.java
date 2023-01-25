package com.saikat1102.cfood.customer_foodPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.saikat1102.cfood.DatabaseHelper;
import com.saikat1102.cfood.R;

public class SingleFoodDetails extends AppCompatActivity {
    TextView food_title, food_price, food_description;
    ElegantNumberButton food_item_counter;
    ImageView imageView, cartImage;

    static int num = 1 ;
    DatabaseHelper databaseHelper;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food_details);
        commence();
        databaseHelper = new DatabaseHelper(this);
        Glide.with(this)
                .load((Uri) getIntent().getParcelableExtra("image"))
                .into(imageView);
        food_title.setText(getIntent().getStringExtra("title"));
        food_price.setText(getIntent().getStringExtra("price")+"tk");
        food_description.setText(getIntent().getStringExtra("description"));


        food_item_counter.setOnClickListener((ElegantNumberButton.OnClickListener) view -> {
             num = Integer.parseInt(food_item_counter.getNumber());
            Toast.makeText(SingleFoodDetails.this, "count " + num, Toast.LENGTH_SHORT).show();
        });

        cartImage.setOnClickListener(view -> {
            String title = getIntent().getStringExtra("title");
            int price = Integer.parseInt(getIntent().getStringExtra("price"));
            String uid = getIntent().getStringExtra("uid");

//            Toast.makeText(this, "aaaaa" +title +" " + price + " " + uid + " " + num, Toast.LENGTH_SHORT).show();

            long id  = databaseHelper.insert_data(title, price, num, uid);
            Toast.makeText(this, "Inserted at " + id , Toast.LENGTH_LONG).show();
        });

    }

    private void commence() {
        food_title = findViewById(R.id.food_title);
        imageView = findViewById(R.id.imageView);
        food_price = findViewById(R.id.food_price);
        food_description = findViewById(R.id.food_description);
        food_item_counter = findViewById(R.id.food_item_counter);
        cartImage = findViewById(R.id.imageView2);

    }
}