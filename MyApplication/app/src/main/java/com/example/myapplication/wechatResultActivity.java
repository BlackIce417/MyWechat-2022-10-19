package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

public class wechatResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_result);

        Intent intent = getIntent();
        intent.putExtra("data","北京时间：\n" +
                Calendar.getInstance().getTime());
        setResult(8,intent);
        finish();
    }
}