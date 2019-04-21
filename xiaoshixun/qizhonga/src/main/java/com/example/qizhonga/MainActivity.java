package com.example.qizhonga;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.qizhonga.adapter.BAdapter;
import com.example.qizhonga.adapter.MyAdapter;
import com.example.qizhonga.bean.BBean;
import com.example.qizhonga.bean.Bean;
import com.example.qizhonga.model.BModels;
import com.example.qizhonga.model.MyModels;
import com.example.qizhonga.presenter.BPresenters;
import com.example.qizhonga.presenter.MyPresenters;
import com.example.qizhonga.view.BView;
import com.example.qizhonga.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

//马畔畔-1808B-2019.3.30-22:26
public class MainActivity extends AppCompatActivity implements MyView, BView {

    private XRecyclerView mXrlv;
    private XRecyclerView mXrlvTwo;
    private ArrayList<Bean.DataBean.DatasBean> list = new ArrayList<>();
    private ArrayList<BBean.DataBean.DatasBean> list1 = new ArrayList<>();
    private MyAdapter myAdapter;
    private BAdapter bAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyPresenters myPresenters = new MyPresenters(new MyModels(), this);
        myPresenters.getData1();
        BPresenters bPresenters = new BPresenters(new BModels(), this);
        bPresenters.getData2();
        initView();
    }

    private void initView() {
        mXrlv = (XRecyclerView) findViewById(R.id.xrlv);
        mXrlvTwo = (XRecyclerView) findViewById(R.id.xrlv_two);
        mXrlv.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter(list, this);
        mXrlv.setAdapter(myAdapter);
        mXrlvTwo.setLayoutManager(new LinearLayoutManager(this));
        bAdapter = new BAdapter(list1, this);
        mXrlvTwo.setAdapter(bAdapter);
    }

    @Override
    public void onSuccess(BBean bean) {
        bAdapter.setAll(bean.getData().getDatas());
    }

    @Override
    public void onSuccess(Bean bean) {
        myAdapter.setAll(bean.getData().getDatas());
    }

    @Override
    public void onFail(String string) {

    }
}
