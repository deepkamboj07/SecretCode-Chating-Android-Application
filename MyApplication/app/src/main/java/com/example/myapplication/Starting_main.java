package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class Starting_main extends AppCompatActivity {
    Timer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        time=new Timer();
        time.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent i=new Intent(Starting_main.this,StartActivity.class);
                startActivity(i);
                finish();

            }
        },2000);
    }
}