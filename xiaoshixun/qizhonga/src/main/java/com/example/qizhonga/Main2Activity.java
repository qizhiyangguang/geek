package com.example.qizhonga;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.qizhonga.adapter.MeiNvAdapter;
import com.example.qizhonga.bean.MeiNvBean;
import com.example.qizhonga.model.MeiNvModels;
import com.example.qizhonga.presenter.MeiNvPresenters;
import com.example.qizhonga.view.MeiNvView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements MeiNvView {
    private int page = 1;
    private ImageView mImg;
    private TextView mTv1;
    private TextView mTv2;
    private XRecyclerView mXrlv;
    private MeiNvPresenters meiNvPresenters;
    private ArrayList<MeiNvBean.ResultsBean> list = new ArrayList<>();
    private MeiNvAdapter meiNvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        meiNvPresenters = new MeiNvPresenters(new MeiNvModels(), this);
        intiData();
        initView();
    }

    private void intiData() {
        meiNvPresenters.getHttp(page);
    }

    private void initView() {
        mImg = (ImageView) findViewById(R.id.img);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mXrlv = (XRecyclerView) findViewById(R.id.xrlv);
        Intent intent = getIntent();
        String title1 = intent.getStringExtra("title1");
        String title2 = intent.getStringExtra("title2");
        String url = intent.getStringExtra("url");
        Glide.with(this).load(url).into(mImg);
        mTv1.setText(title1);
        mTv2.setText(title2);
        mXrlv.setLayoutManager(new LinearLayoutManager(this));
        meiNvAdapter = new MeiNvAdapter(list, this);
        mXrlv.setAdapter(meiNvAdapter);
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                meiNvAdapter.list.clear();
                intiData();
            }

            @Override
            public void onLoadMore() {
                page++;
                intiData();
            }
        });
    }

    @Override
    public void onSuccess(MeiNvBean bean) {
        mXrlv.refreshComplete();
        mXrlv.loadMoreComplete();
        meiNvAdapter.setAll(bean.getResults());
    }

    @Override
    public void onFail(String string) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
