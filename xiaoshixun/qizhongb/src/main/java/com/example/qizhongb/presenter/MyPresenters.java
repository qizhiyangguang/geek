package com.example.qizhongb.presenter;

import com.example.qizhongb.bean.Bean;
import com.example.qizhongb.callback.CallBack;
import com.example.qizhongb.model.MyModel;
import com.example.qizhongb.view.MyView;

public class MyPresenters implements MyPresenter, CallBack {
    private MyModel myModel;
    private MyView myView;

    public MyPresenters(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getData(int page) {
        if (myModel != null) {
            myModel.getData(page, this);
        }
    }

    @Override
    public void onSuccess(Bean bean) {
        if (myView != null) {
            myView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String string) {
        if (myView != null) {
            myView.onFail(string);
        }
    }
}
