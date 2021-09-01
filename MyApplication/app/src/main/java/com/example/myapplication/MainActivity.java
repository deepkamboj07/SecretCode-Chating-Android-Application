package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.myapplication.Model.User;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import Adapter.User_View;
import Fragments.UsersFragments;
import Fragments.chatsFragments;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    FirebaseUser firebaseUser;
    DatabaseReference reference;
    ProgressBar p;
    ImageView setting;

    TextView v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar_main);


        p=findViewById(R.id.progress_main);
        p.setVisibility(ProgressBar.VISIBLE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        v=findViewById(R.id.name);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance().getReference("Users").child(firebaseUser.getUid());

        reference.addValueEventListener(new ValueEventListener() {
          @Override
          public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              User user=dataSnapshot.getValue(User.class);
              v.setText(user.getUsername());

              p.setVisibility(ProgressBar.INVISIBLE);



          }

          @Override
          public void onCancelled(@NonNull DatabaseError error) {

          }
      });


        ViewPager viewPager=findViewById(R.id.view_page);

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new UsersFragments(),"");




        viewPager.setAdapter(viewPagerAdapter);



        setting=findViewById(R.id.ProfileSetting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this,UserProfile.class);
                startActivity(in);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(MainActivity.this,StartActivity.class));
                finish();
                break;

            case R.id.details:
                 startActivity(new Intent(MainActivity.this,AboutApp.class));
                 finish();
                return true;
            case R.id.report:
                return true;
            case R.id.report1:

//
//               final Intent mail= new Intent(Intent.ACTION_VIEW)
//               .setType("plain/text").
//               setData(Uri.parse("deepkamboj0207@gmail.com")).
//                setClassName("com.google.android.gm","com.google.android.gm.ComposeActivityGmail").
//                               putExtra(Intent.EXTRA_EMAIL, new String[]{"deepkamboj0207@gmail.com"}).putExtra(Intent.EXTRA_SUBJECT,"Suggestion")
//                       .putExtra(Intent.EXTRA_TEXT,"type here suggestion");
//                startActivity(mail);


        }
        return false;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{

        private ArrayList<Fragment> fragments;
        private ArrayList<String> titles;

        ViewPagerAdapter(FragmentManager fm){

            super(fm);
            this.fragments=new ArrayList<>();
            this.titles= new ArrayList<>();


        }
        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        public <title> void addFragment(Fragment fragment, String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }


    }



