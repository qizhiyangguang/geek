package com.example.qizhongb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qizhongb.fragment.CollectFragment;
import com.example.qizhongb.fragment.HomeFragment;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIv;
    private Toolbar mToolBar;
    private TabLayout mTab;
    private ViewPager mVp;
    /**
     * 我有话要说
     */
    private Button mBt;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
        mTv = (TextView) findViewById(R.id.tv);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
        mTab.setupWithViewPager(mVp);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        final ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CollectFragment());
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("最新");
        strings.add("推荐");
        mTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mTv.setText(strings.get(tab.getPosition()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return fragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return strings.get(position);
            }
        };
        mVp.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt:
                break;
            case R.id.iv:
                finish();
                break;
        }
    }
}
