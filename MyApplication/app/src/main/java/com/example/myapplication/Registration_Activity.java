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
import android.widget.Toolbar;

import com.example.myapplication.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Registration_Activity extends AppCompatActivity {

    EditText username, email, pass, pass2;
    Button btn_register;

    ProgressBar p;

    FirebaseAuth auth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration_);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);




        username = findViewById(R.id.username);
        email = findViewById(R.id.Email);
        pass = findViewById(R.id.password);
        pass2 = findViewById(R.id.password2);
        p=findViewById(R.id.progress_regis);
        p.setVisibility(ProgressBar.INVISIBLE);

        btn_register = findViewById(R.id.btn_register);

        auth = FirebaseAuth.getInstance();

        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                p.setVisibility(ProgressBar.VISIBLE);

                String txt_username = username.getText().toString();
                String txt_email = email.getText().toString();
                String txt_pass = pass.getText().toString();
                String txt_pass2 = pass2.getText().toString();

                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_pass) || TextUtils.isEmpty(txt_pass2)) {
                    Toast.makeText(Registration_Activity.this, "All Fields are Required", Toast.LENGTH_SHORT).show();
                    p.setVisibility(ProgressBar.INVISIBLE);
                }
             else if (txt_pass.length() < 8) {
                   EditText pass1=findViewById(R.id.password);
                   pass1.setError("Atleast of 8 character");
                    p.setVisibility(ProgressBar.INVISIBLE);
                }
                else if (txt_pass.compareTo(txt_pass2)==1 || txt_pass.compareTo(txt_pass2)==2) {
                   EditText pass2=findViewById(R.id.password2);
                   pass2.setError("Incorrect");
                    p.setVisibility(ProgressBar.INVISIBLE);

                } else {
                    Toast.makeText(Registration_Activity.this, "Registration Successful Wait a Second !", Toast.LENGTH_SHORT).show();
                    register(txt_username, txt_email, txt_pass);


                }
            }
        });

    }




    private void register(String username, String email, String pass){
        auth.createUserWithEmailAndPassword(email,pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser=auth.getCurrentUser();
                            String id=firebaseUser.getUid();

                            reference= FirebaseDatabase.getInstance().getReference("Users").child(id);

                            User user = new User(id,username);

                            reference.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isSuccessful()){
                                        Intent in=new Intent(Registration_Activity.this,    LoginActivity.class);
                                        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(in);
                                        finish();

                                    }
                                }
                            });
                        }else{
                            Toast.makeText(Registration_Activity.this, "You can not Register with this Email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}



