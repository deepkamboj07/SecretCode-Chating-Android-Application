package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.Model.Chat;
import com.example.myapplication.Model.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Adapter.Message;

public class Message_Activity extends AppCompatActivity {

    TextView username,msg;
    FirebaseUser user1;
    DatabaseReference reference;
    Intent in;

    ImageButton btn_image;
    EditText t_send;

    Message msgadap;
    List<Chat> mChat;
    RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_);

        Toolbar toolbar=findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        recyclerView=findViewById(R.id.recycle_msg);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);



        username=findViewById(R.id.name);
       btn_image= findViewById(R.id.btn_send);
       t_send=findViewById(R.id.send_text);
       msg=findViewById(R.id.show_msg);

        in=getIntent();









        String userid=in.getStringExtra("userid");

        user1=FirebaseAuth.getInstance().getCurrentUser();

        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuffer str= new StringBuffer( t_send.getText().toString());


                String str2= str.toString();
                char[] ch=str2.toCharArray();
                int i,j=0;
                for( i=0;i<str2.length();i++)
                {
                    for( j=j+0;j<=str.length();j++ ) {

                        if (str2.charAt(i) == ' ') {
                            j++;
                            break;
                        }
                        if (ch[i] == 'a') {
                            str = str.replace(j, j + 1, "011@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'b') {
                            str = str.replace(j, j + 1, "012@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'c') {
                            str = str.replace(j, j + 1, "013@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'd') {
                            str = str.replace(j, j + 1, "014@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'e') {
                            str = str.replace(j, j + 1, "015@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'f') {
                            str = str.replace(j, j + 1, "016@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'g') {
                            str = str.replace(j, j + 1, "017@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'h') {
                            str = str.replace(j, j + 1, "018@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'i') {
                            str = str.replace(j, j + 1, "019@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'j') {
                            str = str.replace(j, j + 1, "020@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'k') {
                            str = str.replace(j, j + 1, "021@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'l') {
                            str = str.replace(j, j + 1, "022@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'm') {
                            str = str.replace(j, j + 1, "023@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'n') {
                            str = str.replace(j, j + 1, "024@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'o') {
                            str = str.replace(j, j + 1, "025@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'p') {
                            str = str.replace(j, j + 1, "026@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'q') {
                            str = str.replace(j, j + 1, "027@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'r') {
                            str = str.replace(j, j + 1, "028@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 's') {
                            str = str.replace(j, j + 1, "029@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 't') {
                            str = str.replace(j, j + 1, "030@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'u') {
                            str = str.replace(j, j + 1, "031@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'v') {
                            str = str.replace(j, j + 1, "032@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'w') {
                            str = str.replace(j, j + 1, "033@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'x') {
                            str = str.replace(j, j + 1, "034@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'y') {
                            str = str.replace(j, j + 1, "035@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'z') {
                            str = str.replace(j, j + 1, "036@");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'A') {
                            str = str.replace(j, j + 1, "111#");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'B') {
                            str = str.replace(j, j + 1, "112#");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'C') {
                            str = str.replace(j, j + 1, "113#");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'D') {
                            str = str.replace(j, j + 1, "114#");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'E') {
                            str = str.replace(j, j + 1, "115#");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'F') {
                            str = str.replace(j, j + 1, "116#");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'G') {
                            str = str.replace(j, j + 1, "117#");
                            j = j + 4;
                            break;
                        } else if (ch[i] == 'H')
                        {

                            str= str.replace(j, j + 1, "118#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'I')
                        {
                            str= str.replace(j, j + 1, "119#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'J')
                        {
                            str= str.replace(j, j + 1, "120#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'K')
                        {
                            str= str.replace(j, j + 1, "121#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'L')
                        {
                            str= str.replace(j, j + 1, "122#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'M')
                        {
                            str= str.replace(j, j + 1, "123#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'N')
                        {
                            str= str.replace(j, j + 1, "124#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'O')
                        {
                            str= str.replace(j, j + 1, "125#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'P')
                        {
                            str= str.replace(j, j + 1, "126#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'Q')
                        {
                            str= str.replace(j, j + 1, "127#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'R')
                        {
                            str= str.replace(j, j + 1, "128#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'S')
                        {
                            str= str.replace(j, j + 1, "129#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'T')
                        {
                            str= str.replace(j, j + 1, "130#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'U')
                        {
                            str= str.replace(j, j + 1, "131#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'V')
                        {
                            str= str.replace(j, j + 1, "132#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'W')
                        {
                            str= str.replace(j, j + 1, "133#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'X')
                        {
                            str= str.replace(j, j + 1, "134#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'Y')
                        {
                            str= str.replace(j, j + 1, "135#");
                            j= j+4;
                            break;
                        }
                        else if (ch[i] == 'Z')
                        {
                            str= str.replace(j, j + 1, "136#");
                            j= j+4;
                            break;
                        }
                        else{
                            j++;
                            break;
                        }
                    }
                }

                str2=str.toString();

                if(!str2.equals(""))
                {
                    sendMessage(user1.getUid(), userid,str2);
                }else{
                    Toast.makeText(Message_Activity.this, "Empty Message can't send", Toast.LENGTH_SHORT).show();
                }
                t_send.setText("");


            }
        });

        user1= FirebaseAuth.getInstance().getCurrentUser();
        reference= FirebaseDatabase.getInstance().getReference("Users").child(userid);

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User user=snapshot.getValue(User.class);
                username.setText(user.getUsername());
               readMessage(user1.getUid(),userid);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






    }

    private void sendMessage(String sender, String reciver, String message){

        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();

        HashMap<String, String> hashMap=new HashMap<>();
        hashMap.put("sender",sender);
        hashMap.put("recevier",reciver);
        hashMap.put("message",message);

        reference.child("Chats").push().setValue(hashMap);


    }

    private void readMessage(String myid, String userid  ){
        mChat=new ArrayList<>();

        reference=FirebaseDatabase.getInstance().getReference("Chats");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mChat.clear();
                for(DataSnapshot dataSnapshot: snapshot.getChildren()){
                    Chat chat=dataSnapshot.getValue(Chat.class);
                    Chat name=dataSnapshot.getValue(Chat.class);
                    if(chat.getRecevier().equals(myid) && chat.getSender().equals(userid) || chat.getRecevier().equals(userid) && chat.getSender().equals(myid)){
                        mChat.add(chat);

                    }
                    msgadap=new Message(Message_Activity.this, mChat);
                    recyclerView.setAdapter(msgadap);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}