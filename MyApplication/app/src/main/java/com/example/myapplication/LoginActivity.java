package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {


    EditText email,pass;
    Button btn_login;
    FirebaseAuth auth;
    ProgressBar p;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        auth=FirebaseAuth.getInstance();

        email=findViewById(R.id.email1);
        pass=findViewById(R.id.password1);
        btn_login=findViewById(R.id.btn_login);
        p=findViewById(R.id.progress_login);
        p.setVisibility(ProgressBar.INVISIBLE);


        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String txt_email=email.getText().toString();
                String txt_pass=pass.getText().toString();

                if(TextUtils.isEmpty((txt_email)) || TextUtils.isEmpty((txt_pass)) ) {
                    Toast.makeText(LoginActivity.this, "All Fields are Required", Toast.LENGTH_SHORT).show();
                    if (TextUtils.isEmpty((txt_email))) {
                        EditText email = findViewById(R.id.email1);
                        email.setError("Invalid Email");
                    }
                    else{
                        EditText pass=findViewById(R.id.password1);
                        pass.setError("Incorrect Password");
                    }
                }
                else{

                    p.setVisibility(ProgressBar.VISIBLE);
                    auth.signInWithEmailAndPassword(txt_email,txt_pass)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(LoginActivity.this, "Login Successful !", Toast.LENGTH_SHORT).show();
                                        Intent in=new Intent(LoginActivity.this,MainActivity.class);
                                        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(in);
                                        finish();
                                    }else{
                                        Toast.makeText(LoginActivity.this, "Wrong Password or Email", Toast.LENGTH_SHORT).show();
                                        p.setVisibility(ProgressBar.INVISIBLE);
                                    }
                                }
                            });
                }
            }
        });






    }


}