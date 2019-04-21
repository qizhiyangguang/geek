package com.example.buju;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView mTv;
    @BindView(R.id.toolBar)
    Toolbar mToolBar;
    @BindView(R.id.tab)
    TabLayout mTab;
    @BindView(R.id.fragment)
    FrameLayout mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        mTab.addTab(mTab.newTab().setText("首页 "));
        mTab.addTab(mTab.newTab().setText("收藏 "));
    }
}
