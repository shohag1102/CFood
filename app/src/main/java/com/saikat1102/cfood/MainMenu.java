package com.saikat1102.cfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    Button Signup, SignwithPhone, SignwithEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        init();

        SignwithEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, ChooseOne.class);
                intent.putExtra("Home", "Email");
                startActivity(intent);
                finish();
            }
        });
        SignwithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, ChooseOne.class);
                intent.putExtra("Home", "Phone");
                startActivity(intent);
                finish();
            }
        });
        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenu.this, ChooseOne.class);
                intent.putExtra("Home", "SignUp");
                startActivity(intent);
                finish();
            }
        });
    }

    public void init(){
        SignwithEmail = findViewById(R.id.SignwithEmail);
        SignwithPhone = findViewById(R.id.SignwithPhone);
        Signup = findViewById(R.id.Signup);
    }
}