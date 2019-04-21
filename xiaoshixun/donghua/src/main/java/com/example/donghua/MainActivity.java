package com.example.donghua;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

//马畔畔-1808D-16：24
public class MainActivity extends AppCompatActivity {

    private ImageView mIv;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initAnimation();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mTv = (TextView) findViewById(R.id.tv);
        new CountDownTimer(6000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTv.setText("倒计时："+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        }.start();
    }

    private void initAnimation() {
        //缩放动画
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f,3.0f,1.0f,3.0f,
                Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        //1s = 1000ms = 1000*1000 us = 1000*1000*1000ns
        scaleAnimation.setDuration(4000);
        mIv.setAnimation(scaleAnimation);
    }

}
