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

public class discoverFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<String> newsTitle = new ArrayList<>();
    private ArrayList<String> newsContent = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_discover, container, false);

        recyclerView = view.findViewById(R.id.item3);
        initData();
        initWeChatView();
        return view;
    }

    private void initData() {
        int MaxSize = 15;
        for (int i = 0; i < MaxSize; i++){
            newsTitle.add("news" + (i + 1));
            newsContent.add("this is news" + (i + 1));
        }

    }
    private void initWeChatView(){
        Context context = this.getActivity();
        discoverAdapter mAdapter = new discoverAdapter(context,newsTitle,newsContent);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }

}
