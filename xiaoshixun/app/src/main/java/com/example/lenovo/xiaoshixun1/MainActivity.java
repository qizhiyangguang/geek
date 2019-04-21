package com.example.lenovo.xiaoshixun1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 欢迎来到积云教育
     */
    private TextView mTv;
    /**
     * 跳过
     */
    private Button mBt;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
        mIv = (ImageView) findViewById(R.id.iv);
        initAnimation();
    }

    private void initAnimation() {
        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 3.0f, 1.0f, 3.0f,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        //1s = 1000ms = 1000*1000 us = 1000*1000*1000ns
        scaleAnimation.setDuration(4000);
        mIv.setAnimation(scaleAnimation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
