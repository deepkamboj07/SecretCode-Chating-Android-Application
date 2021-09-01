package Adapter;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Encoder_Activity;
import com.example.myapplication.Message_Activity;
import com.example.myapplication.Model.Chat;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class Message extends RecyclerView.Adapter<Message.ViewHolder>  {

    public static final int MSG=0;
    public static final int MSG1=1;
    private Context mContext;
    private List<Chat> mChat;

    FirebaseUser user;

    public Message(Context mContext, List<Chat> mChat){
        this.mChat=mChat;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public Message.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == MSG) {
            view = LayoutInflater.from(mContext).inflate(R.layout.chat2, parent, false);
            return new  Message.ViewHolder(view);
        }
        else{
            view = LayoutInflater.from(mContext).inflate(R.layout.chat, parent, false);
            return new  Message.ViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull Message.ViewHolder holder, int position) {

        Chat chat=mChat.get(position);
        holder.show_sms.setText(chat.getMessage());
        //holder.show_name.setText(chat.getUsername());



    }

    @Override
    public int getItemCount()
    {
        return mChat.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView show_sms,show_name;


        public ViewHolder(View itemView ){
            super(itemView);

            show_sms=itemView.findViewById(R.id.show_msg);
            show_name=itemView.findViewById(R.id.name);

           show_sms.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    ClipboardManager clipboardManager=(ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                    clipboardManager.setText(show_sms.getText());
                    Toast.makeText(mContext," Encoding Symbols" ,Toast.LENGTH_SHORT).show();

                    ClipData pasteData= clipboardManager.getPrimaryClip();
                    ClipData.Item item=pasteData.getItemAt(0);

                    StringBuffer paste= new StringBuffer(item.getText().toString());

                    Encoder_Activity.convert(paste);

                    Intent in=new Intent(mContext.getApplicationContext(),Encoder_Activity.class);

                    mContext.startActivity(in);


                    return true;
                }
            });


        }
    }

    @Override
    public int getItemViewType(int position) {
        user= FirebaseAuth.getInstance().getCurrentUser();
        if(mChat.get(position).getSender().equals(user.getUid())) {
            return MSG;
        }
        else{
            return MSG1;
        }


    }





}

