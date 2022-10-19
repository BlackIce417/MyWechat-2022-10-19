package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class discoverActivity extends AppCompatActivity {
    private Button button_care;
    private TextView textView_userName,textView_userID,textView_following,textView_followed;
    private ImageView imageView_Avatar;
    private boolean status = false;
    private int iFollow = 50;
    private int followMe = 100;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);

        button_care = findViewById(R.id.care);
        textView_userName = findViewById(R.id.userName);
        textView_userID = findViewById(R.id.userID);
        textView_following = findViewById(R.id.caring);
        textView_followed = findViewById(R.id.cared);
        imageView_Avatar = findViewById(R.id.avatar);

        textView_userName.setText("user_rexx");
        textView_userID.setText("@user_rexx");
        textView_following.setText(iFollow + "  正在关注");
        textView_followed.setText(followMe + "  关注者");

        isfollowed();
    }

    private void isfollowed() {
        button_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(discoverActivity.this, discoverResultActivity.class);
                intent.putExtra("isFollowed", status);
                intent.putExtra("iFollow",iFollow);
                intent.putExtra("followMe",followMe);
                discoverResultLauncher.launch(intent);
            }
        });
    }

    public ActivityResultLauncher discoverResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 0) {
                        button_care.setText("followed");
                        button_care.setTextColor(Color.parseColor("#000000"));
                        button_care.setBackgroundColor(Color.parseColor("#FFFFFF"));
                        followMe = result.getData().getIntExtra("retFollowMe",followMe);
                        textView_followed.setText(followMe + "关注者");
                        status = true;
                    } else {
                        button_care.setText("follow");
                        button_care.setTextColor(Color.parseColor("#FFFFFF"));
                        button_care.setBackgroundColor(Color.parseColor("#000000"));
                        followMe = result.getData().getIntExtra("retFollowMe",followMe);
                        textView_followed.setText(followMe + "关注者");
                        status = false;
                    }
                }
            }
    );
}