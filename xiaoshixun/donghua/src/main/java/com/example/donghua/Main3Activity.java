package com.example.donghua;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    private ImageView mIv;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initAnim();
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
                           Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                           startActivity(intent);
                       }
                   }.start();
               }
      private void initAnim() {
              Animation animation = AnimationUtils.loadAnimation(Main3Activity.this, R.anim.anim);
              mIv.setAnimation(animation);
              animation.setAnimationListener(new Animation.AnimationListener() {
                  @Override
                  public void onAnimationStart(Animation animation) {

                  }

                  @Override
                  public void onAnimationEnd(Animation animation) {
                      Intent intent = new Intent(Main3Activity.this, Main4Activity.class);
                      startActivity(intent);
                      overridePendingTransition(R.anim.anim, R.anim.anim2);
                      finish();
                  }

                  @Override
                  public void onAnimationRepeat(Animation animation) {

                  }
              });
          }
}
