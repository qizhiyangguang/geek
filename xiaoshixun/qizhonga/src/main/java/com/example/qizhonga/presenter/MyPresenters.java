package com.example.qizhonga.presenter;

import com.example.qizhonga.bean.Bean;
import com.example.qizhonga.callback.CallBack;
import com.example.qizhonga.model.MyModel;
import com.example.qizhonga.view.MyView;

public class MyPresenters implements MyPresenter, CallBack {
    private MyModel myModel;
    private MyView myView;

    public MyPresenters(MyModel myModel, MyView myView) {
        this.myModel = myModel;
        this.myView = myView;
    }

    @Override
    public void getData1() {
        if (myModel != null) {
            myModel.getData1(this);
        }
    }

    @Override
    public void onSuccess(Bean bean) {
        if (myView != null) {
            myView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String str) {
        if (myView != null) {
            myView.onFail(str);
        }
    }


}
