package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StartActivity extends AppCompatActivity {
    Button login, register;

    FirebaseUser firebaseUser;
    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        if(firebaseUser!=null)
        {
            Intent in= new Intent(StartActivity.this,MainActivity.class);
            startActivity(in);
            finish();
        }

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        login=findViewById(R.id.login);
        register=findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(StartActivity.this,LoginActivity.class);
                startActivity(in);

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(StartActivity.this,Registration_Activity.class);
                startActivity(in);
            }
        });
    }
}
