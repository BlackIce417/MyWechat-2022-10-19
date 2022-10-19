package com.example.myapplication;

import android.content.Context;
import android.os.Bundle;

import android.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class wechatFragment extends Fragment {
    private RecyclerView recyclerView;
    private final ArrayList<String> userName = new ArrayList<>();
    private final ArrayList<String> message = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_wechat, container, false);

        recyclerView = view.findViewById(R.id.item1);
        initData();
        initWeChatView();
        return view;
    }

    private void initData() {
        int maxListSize = 15;
        for (int i = 0; i < maxListSize; i++) {
            userName.add("user" + (i + 1));
            message.add("hello,I am user" + (i + 1));
        }
    }

    private void initWeChatView() {
        Context context = this.getActivity();
        wechatAdapter mAdapter = new wechatAdapter(context,userName,message);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }
}