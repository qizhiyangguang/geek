package com.example.qizhongb;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qizhongb.adapter.MyAdapter;
import com.example.qizhongb.bean.Bean;
import com.example.qizhongb.model.MyModels;
import com.example.qizhongb.presenter.MyPresenters;
import com.example.qizhongb.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

import static android.support.v7.widget.LinearLayoutManager.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MyView {

    /**
     * 话题
     */
    private int page = 1;
    private TextView mTv;
    private Toolbar mToolBar;
    private TabLayout mTab;
    private XRecyclerView mXrlv;
    private ImageView mIv;
    private ArrayList<Bean.DataBean.DatasBean> list = new ArrayList<>();
    private MyAdapter myAdapter;
    private MyPresenters myPresenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPresenters = new MyPresenters(new MyModels(), this);
        initData();
        initView();
    }

    private void initData() {
        myPresenters.getData(page);
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        mToolBar = (Toolbar) findViewById(R.id.toolBar);
        mTab = (TabLayout) findViewById(R.id.tab);
        mIv = (ImageView) findViewById(R.id.iv);
        mIv.setOnClickListener(this);
        mXrlv = (XRecyclerView) findViewById(R.id.xrlv);
        mToolBar.setTitle("");
        setSupportActionBar(mToolBar);
        mTab.addTab(mTab.newTab().setText("其他话题"));
        mXrlv.setLayoutManager(new GridLayoutManager(this, 2));
        myAdapter = new MyAdapter(list, this);
        mXrlv.setAdapter(myAdapter);
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                myAdapter.list.clear();
                initData();
            }

            @Override
            public void onLoadMore() {
                page++;
                initData();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.iv:
                finish();
                break;
        }
    }

    @Override
    public void onSuccess(Bean bean) {
        mXrlv.refreshComplete();
        mXrlv.loadMoreComplete();
        myAdapter.setAll(bean.getData().getDatas());
    }

    @Override
    public void onFail(String string) {

    }
}
