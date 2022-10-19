package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contactsAdapter extends RecyclerView.Adapter<contactsAdapter.Myholder> {
    private Context context;
    private ArrayList<String> userName;

    public contactsAdapter(Context context,ArrayList<String> userName){
        this.context = context;
        this.userName = userName;
    }
    @NonNull
    @Override
    public contactsAdapter.Myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_contacts, parent, false);
        Myholder myholder;
        myholder = new Myholder(view);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull contactsAdapter.Myholder holder, int position) {
        holder.textView1.setText(userName.get(position));
    }

    @Override
    public int getItemCount() {
        return userName.size();
    }

    public class Myholder extends RecyclerView.ViewHolder{
        private TextView textView1;
        LinearLayout linearLayoutOfContacts;

        public Myholder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1_contacts);
            linearLayoutOfContacts = itemView.findViewById(R.id.linearlayout_contacts);
        }
    }
}
