package com.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.xiaoshixun1.R;

public class Main4Activity extends AppCompatActivity {

    private ImageView mIv;
    private TextView mTv1;
    private TextView mTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        Intent intent = getIntent();
        String u = intent.getStringExtra("u");
        String r = intent.getStringExtra("r");
        String l = intent.getStringExtra("l");
        Glide.with(this).load(u).into(mIv);
        mTv1.setText(r);
        mTv2.setText(l);
    }
}
