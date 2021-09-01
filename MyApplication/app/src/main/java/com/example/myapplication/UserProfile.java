package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.Model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {

    FirebaseUser firebaseUser;
    DatabaseReference reference;
    TextView username;
    EditText NewUsername;
    Button update,edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);


        Toolbar toolbar=findViewById(R.id.toolbar_profile);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        username=findViewById(R.id.profile_username);
        edit=findViewById(R.id.edit_button);

        NewUsername=findViewById(R.id.edit_username);
        NewUsername.setVisibility(EditText.INVISIBLE);
        update=findViewById(R.id.update_button);
        update.setVisibility(Button.INVISIBLE);

        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        reference=FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user= snapshot.getValue(User.class);
                username.setText(user.getUsername());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edit.setVisibility(Button.INVISIBLE);
                username.setVisibility(TextView.INVISIBLE);

                NewUsername.setVisibility(EditText.VISIBLE);
                update.setVisibility(Button.VISIBLE);

                String oldName= username.getText().toString();



                update.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        edit.setVisibility(Button.VISIBLE);
                        username.setVisibility(TextView.VISIBLE);


                        String newName = NewUsername.getText().toString();

                        if(!oldName.equals(NewUsername.getText().toString()) && !newName.isEmpty()) {


                            reference.child("username").setValue(newName);
                            NewUsername.setText("");



                            Toast.makeText(UserProfile.this,"Username has been changed",Toast.LENGTH_LONG).show();

                        }


                        else{
                            Toast.makeText(UserProfile.this,"Username is unchanged",Toast.LENGTH_LONG).show();
                        }


                        NewUsername.setVisibility(EditText.INVISIBLE);
                        update.setVisibility(Button.INVISIBLE);


                    }
                });



            }
        });


    }
}