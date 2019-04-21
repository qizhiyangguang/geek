package com.example.donghua;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {


    private static final int RELATIVE_TO_PARENT = 360;
    private ImageView mIv;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        initView();
        initImg();
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
                           Intent intent = new Intent(Main4Activity.this,Main5Activity.class);
                           startActivity(intent);
                       }
                   }.start();
    }
    private void initImg() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, RELATIVE_TO_PARENT, 0.2F, RELATIVE_TO_PARENT, 0.2F);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration(5000);
        rotateAnimation.setRepeatMode(0);
        rotateAnimation.setDetachWallpaper(true);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
//                translateAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mIv.setAnimation(rotateAnimation);
        rotateAnimation.start();

    }
}
