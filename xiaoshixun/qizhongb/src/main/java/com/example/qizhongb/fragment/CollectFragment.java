package com.example.qizhongb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qizhongb.R;
import com.example.qizhongb.adapter.CollectAdapter;
import com.example.qizhongb.bean.Bean;
import com.example.qizhongb.model.MyModels;
import com.example.qizhongb.presenter.MyPresenters;
import com.example.qizhongb.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class CollectFragment extends Fragment implements MyView {

    private int page = 1;
    private View view;
    private XRecyclerView mXrlv;
    private ArrayList<Bean.DataBean.DatasBean> list = new ArrayList<>();
    private CollectAdapter collectAdapter;
    private MyPresenters myPresenters;

    public CollectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_collect, container, false);
        myPresenters = new MyPresenters(new MyModels(), this);
        initData();
        initView(inflate);
        return inflate;
    }

    private void initData() {
        myPresenters.getData(page);
    }

    private void initView(View inflate) {
        mXrlv = (XRecyclerView) inflate.findViewById(R.id.xrlv);
        mXrlv.setLayoutManager(new LinearLayoutManager(getContext()));
        collectAdapter = new CollectAdapter(list, getContext());
        mXrlv.setAdapter(collectAdapter);
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                collectAdapter.list.clear();
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
    public void onSuccess(Bean bean) {
        mXrlv.refreshComplete();
        mXrlv.loadMoreComplete();
        collectAdapter.setAll(bean.getData().getDatas());
    }

    @Override
    public void onFail(String string) {

    }
}
