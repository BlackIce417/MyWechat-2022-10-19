package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class contactsFragment extends Fragment {
    private RecyclerView recyclerView;
    private final ArrayList<String> userName = new ArrayList<>();

    public contactsFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        recyclerView = view.findViewById(R.id.item2);
        initData();
        initWeChatView();
        return view;
    }

    private void initData() {
        int maxListSize = 15;
        for (int i = 0; i < maxListSize; i++) {
            userName.add("user" + (i + 1));
        }
    }

    private void initWeChatView() {
        Context context = this.getActivity();
        contactsAdapter mAdapter = new contactsAdapter(context,userName);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }

}
