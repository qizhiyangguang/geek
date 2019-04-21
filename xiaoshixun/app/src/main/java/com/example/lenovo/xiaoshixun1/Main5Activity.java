package com.example.lenovo.xiaoshixun1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class Main5Activity extends AppCompatActivity {

    private ProgressBar mPb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        initView();
    }

    private void initView() {
        mPb = (ProgressBar) findViewById(R.id.pb);
    }
}
