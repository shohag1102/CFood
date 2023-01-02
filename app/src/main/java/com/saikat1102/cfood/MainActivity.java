package com.saikat1102.cfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar progress_horizontal;

    private int progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                splash();
                mainMenu();
            }
        });
        thread.start();



    }

    private void mainMenu() {
        Intent intent = new Intent(MainActivity.this, MainMenu.class);
        startActivity(intent);
        finish();
    }

    private void splash() {
        for(progress = 10; progress<=100; progress+=10){
            try {
                Thread.sleep(300);
                progress_horizontal.setProgress(progress);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void init(){
        progress_horizontal = findViewById(R.id.progress_horizontal);
    }

}