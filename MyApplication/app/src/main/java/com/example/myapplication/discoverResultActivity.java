package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class discoverResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover_result);

        Intent intent = getIntent();
        boolean isFollowed = intent.getBooleanExtra("isFollowed", false);
        int iFollow = intent.getIntExtra("iFollow",-1);
        int followMe = intent.getIntExtra("followMe",-1);
        Log.d("gg","isFollowed = " + isFollowed);
        if (isFollowed) {
            intent.putExtra("retFollowMe",followMe - 1);
            setResult(1, intent);
        }
        else {
            intent.putExtra("retFollowMe",followMe + 1);
            setResult(0, intent);
        }
        finish();
    }
}