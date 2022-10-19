package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.widget.TextView;

public class wechatActivity extends AppCompatActivity {
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat);

        textView1 = findViewById(R.id.wechat_username);
        Intent intent = new Intent(wechatActivity.this,wechatResultActivity.class);
        test.launch(intent);
    }

    public ActivityResultLauncher test = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 8) {
                        textView1.setText(result.getData().getStringExtra("data"));
                    }
                }
            }
    );
}