package Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Model.User;
import com.example.myapplication.R;
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

import static com.example.myapplication.R.layout.fragment_users_fragments;

public class UsersFragments extends Fragment {

    private RecyclerView recyclerView;
    private User_View user_view;
    private List<User> mUser;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(fragment_users_fragments,container,false);

        recyclerView=view.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        mUser=new ArrayList<>();

        readUser();

        return view;
    }

    private void readUser() {

        FirebaseUser firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("Users");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mUser.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    User user=dataSnapshot.getValue(User.class);

                    assert user!=null;
                    assert firebaseUser!=null;
                    if(!user.getId().equals(firebaseUser.getUid())){
                        mUser.add(user);
                    }

                }
                user_view=new User_View(getContext(),mUser);
                recyclerView.setAdapter(user_view);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}