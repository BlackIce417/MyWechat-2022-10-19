package com.example.myapplication;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
implements View.OnClickListener{

    private final Fragment wechatFragment = new wechatFragment();
    private final Fragment contactsFragment = new contactsFragment();
    private final Fragment discoverFragment = new discoverFragment();
    private final Fragment myselfFragment = new myselfFragment();
    private FragmentManager fragmentManager;

    private LinearLayout mWechat;
    private LinearLayout mContacts;
    private LinearLayout mDiscover;
    private LinearLayout mMyself;

    private ImageView mWeChat_img;
    private ImageView mContacts_img;
    private ImageView mDiscover_img;
    private ImageView mMyself_img;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        mWechat = findViewById(R.id.id_wechat);
        mContacts = findViewById(R.id.id_contacts);
        mDiscover = findViewById(R.id.id_discover);
        mMyself = findViewById(R.id.id_myself);

        textView1 = findViewById(R.id.id_WeChat_text);
        textView2 = findViewById(R.id.id_contacts_text);
        textView3 = findViewById(R.id.id_discover_text);
        textView4 = findViewById(R.id.id_myself_text);

        mWechat.setOnClickListener(this);
        mContacts.setOnClickListener(this);
        mDiscover.setOnClickListener(this);
        mMyself.setOnClickListener(this);

        mWeChat_img =(ImageView)findViewById(R.id.id_WeChat_img);
        mContacts_img =(ImageView)findViewById(R.id.id_contacts_img);
        mDiscover_img = (ImageView)findViewById(R.id.id_discover_img);
        mMyself_img = (ImageView) findViewById(R.id.id_myself_img);

        initFragment();
        showfragment(1);

    }

    private void initFragment(){
        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.id_content, wechatFragment);
        transaction.add(R.id.id_content, discoverFragment);
        transaction.add(R.id.id_content, contactsFragment);
        transaction.add(R.id.id_content, myselfFragment);
        transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction){

        transaction.hide(wechatFragment);
        transaction.hide(contactsFragment);
        transaction.hide(discoverFragment);
        transaction.hide(myselfFragment);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        becomedark();
        switch (v.getId()){
            case R.id.id_wechat:
                showfragment(1);
                break;
            case R.id.id_contacts:
                showfragment(2);
                break;
            case R.id.id_discover:
                showfragment(3);
                break;
            case R.id.id_myself:
                showfragment(4);
                break;
            default:
                break;
        }
    }
    private void showfragment(int i) {
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 1:
                transaction.show(wechatFragment);
                textView1.setTextColor(Color.parseColor("#4CAF50"));
                mWeChat_img.setImageResource(R.drawable.wechat2);
                break;
            case 2:
                transaction.show(contactsFragment);
                textView2.setTextColor(Color.parseColor("#4CAF50"));
                mContacts_img.setImageResource(R.drawable.contacts2);
                break;
            case 3:
                transaction.show(discoverFragment);
                textView3.setTextColor(Color.parseColor("#4CAF50"));
                mDiscover_img.setImageResource(R.drawable.discover2);
                break;
            case 4:
                transaction.show(myselfFragment);
                textView4.setTextColor(Color.parseColor("#4CAF50"));
                mMyself_img.setImageResource(R.drawable.myself2);
                break;
            default:
                break;
        }
        transaction.commit();
    }
    private void becomedark(){

        mWeChat_img.setImageResource(R.drawable.wechat1);
        mContacts_img.setImageResource(R.drawable.contacts1);
        mDiscover_img.setImageResource(R.drawable.discover1);
        mMyself_img.setImageResource(R.drawable.myself1);

        textView1.setTextColor(Color.parseColor("#FF000000"));
        textView2.setTextColor(Color.parseColor("#FF000000"));
        textView3.setTextColor(Color.parseColor("#FF000000"));
        textView4.setTextColor(Color.parseColor("#FF000000"));

        mWechat.setBackgroundColor(Color.parseColor("#FFFFFF"));
        mContacts.setBackgroundColor(Color.parseColor("#FFFFFF"));
        mDiscover.setBackgroundColor(Color.parseColor("#FFFFFF"));
        mMyself.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }

}