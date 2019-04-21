package com.example.qizhongb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qizhongb.R;
import com.example.qizhongb.adapter.HomeAdapter;
import com.example.qizhongb.bean.Bean;
import com.example.qizhongb.model.MyModels;
import com.example.qizhongb.presenter.MyPresenters;
import com.example.qizhongb.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements MyView {

    private int page = 1;
    private View view;
    private XRecyclerView mXrlv;
    private MyPresenters myPresenters;
    private ArrayList<Bean.DataBean.DatasBean> list = new ArrayList<>();
    private HomeAdapter homeAdapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
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
        homeAdapter = new HomeAdapter(list, getContext());
        mXrlv.setAdapter(homeAdapter);
        mXrlv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                homeAdapter.list.clear();
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
        homeAdapter.setAll(bean.getData().getDatas());
    }

    @Override
    public void onFail(String string) {

    }
}
