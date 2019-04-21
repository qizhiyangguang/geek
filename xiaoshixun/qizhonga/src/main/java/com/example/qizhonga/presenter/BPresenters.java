package com.example.qizhonga.presenter;

import com.example.qizhonga.bean.BBean;
import com.example.qizhonga.callback.BCallBack;
import com.example.qizhonga.model.BModel;
import com.example.qizhonga.view.BView;

public class BPresenters implements BPresenter, BCallBack {
    private BModel model;
    private BView view;

    public BPresenters(BModel model, BView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void getData2() {
        if (model != null) {
            model.getData2(this);
        }
    }

    @Override
    public void onSuccess(BBean bean) {
        if (view != null) {
            view.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String string) {
        if (view != null) {
            view.onFail(string);
        }
    }
}
