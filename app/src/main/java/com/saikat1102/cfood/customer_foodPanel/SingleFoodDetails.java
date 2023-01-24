package com.saikat1102.cfood.customer_foodPanel;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.saikat1102.cfood.R;

public class SingleFoodDetails extends AppCompatActivity {
    TextView food_title, food_price, food_description;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_food_details);
        commence();

        //Glide.with(this).load((Bitmap) getIntent().getParcelableExtra("image")).into(imageView);
        //food_title.setText(String.valueOf(getIntent().getParcelableExtra("image")));

       // Bitmap bitmap = (Bitmap) getIntent().getParcelableExtra("image");
        //imageView.setImageBitmap(bitmap);

        Glide.with(this)
                .load((Uri) getIntent().getParcelableExtra("image"))
                .into(imageView);

        //imageView.setImageURI((Uri) getIntent().getParcelableExtra("image"));
        food_title.setText(getIntent().getStringExtra("title"));
        food_price.setText(getIntent().getStringExtra("price")+"tk");
        food_description.setText(getIntent().getStringExtra("description"));
    }

    private void commence() {
        food_title = findViewById(R.id.food_title);
        imageView = findViewById(R.id.imageView);
        food_price = findViewById(R.id.food_price);
        food_description = findViewById(R.id.food_description);
    }
}