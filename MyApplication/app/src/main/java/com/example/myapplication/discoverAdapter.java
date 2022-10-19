package com.example.myapplication;

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

public class discoverAdapter extends RecyclerView.Adapter<discoverAdapter.Myholder> {
    private Context context;
    private ArrayList<String> newsTitle;
    private ArrayList<String> newsContent;

    public discoverAdapter(Context context,ArrayList<String> newsTitle,ArrayList<String> newsContent){
        this.context = context;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_discover, parent, false);
        Myholder myholder;
        myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder holder, int position) {
        holder.textView1.setText(newsTitle.get(position));
        holder.textView2.setText(newsContent.get(position));
        holder.linearLayoutOfDiscover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,discoverActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsTitle.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        private TextView textView1;
        private TextView textView2;
        LinearLayout linearLayoutOfDiscover;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1_discover);
            textView2 = itemView.findViewById(R.id.textView2_discover);

            linearLayoutOfDiscover = itemView.findViewById(R.id.linearlayout_discover);
        }
    }
}
