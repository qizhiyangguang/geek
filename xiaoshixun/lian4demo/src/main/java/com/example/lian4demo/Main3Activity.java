package com.example.lian4demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Main3Activity extends AppCompatActivity {

    private ImageView mIv;
    private EditText mEt1;
    private EditText mEt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mEt1 = (EditText) findViewById(R.id.et1);
        mEt2 = (EditText) findViewById(R.id.et2);
        Intent intent = getIntent();
        String img = intent.getStringExtra("img");
        String url = intent.getStringExtra("url");
        String url1 = intent.getStringExtra("url1");
        Glide.with(this).load(img).into(mIv);
        mEt1.setText(url);
        mEt2.setText(url1);
        finish();
    }
}
