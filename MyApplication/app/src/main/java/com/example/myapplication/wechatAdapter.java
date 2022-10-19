package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class wechatAdapter extends RecyclerView.Adapter<wechatAdapter.Myholder> {
    private final Context context;
    private ArrayList<String> userName;
    private ArrayList<String> message;

    public wechatAdapter(Context context, ArrayList<String> userName, ArrayList<String> message) {
        this.context = context;
        initData(userName, message);
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_wechat, parent, false);
        Myholder myholder;
        myholder = new Myholder(view);
        return myholder;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull wechatAdapter.Myholder holder, @SuppressLint("RecyclerView") int position) {
        holder.textView1.setText(userName.get(position));
        holder.textView2.setText(message.get(position));
        holder.linearLayoutOfWeChat.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, wechatActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return userName.size();
    }

    public static class Myholder extends RecyclerView.ViewHolder {
        private final TextView textView1;
        private final TextView textView2;
        LinearLayout linearLayoutOfWeChat;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1_wechat);
            textView2 = itemView.findViewById(R.id.textView2_wechat);
            linearLayoutOfWeChat = itemView.findViewById(R.id.linearlayout_wechat);
        }
    }

    public void initData(ArrayList<String> userName, ArrayList<String> message) {
        this.userName = userName;
        this.message = message;
    }
}
