package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Message_Activity;
import com.example.myapplication.Model.User;
import com.example.myapplication.R;

import java.util.List;

import static com.example.myapplication.R.layout.user_item;

public class User_View extends RecyclerView.Adapter<User_View.ViewHolder> {

    private Context mContext;
    private List<User> mUser;
    public User_View(Context mContext, List<User> mUser ){
         this.mUser=mUser;
         this.mContext=mContext;
    }

    @NonNull
    @Override
    public User_View.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.row_user,parent,false);
        return new User_View.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull User_View.ViewHolder holder, int position) {

        final User user=mUser.get(position);
        holder.username.setText(user.getUsername());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(mContext, Message_Activity.class);
                in.putExtra("userid",user.getId());
                mContext.startActivity(in);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView username;

        public ViewHolder(View itemView ){
            super(itemView);

            username=itemView.findViewById(R.id.username);


        }
    }
}
