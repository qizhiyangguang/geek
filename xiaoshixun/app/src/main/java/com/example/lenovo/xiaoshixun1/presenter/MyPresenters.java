package com.example.lenovo.xiaoshixun1.presenter;

import com.example.lenovo.xiaoshixun1.View.MyView;
import com.example.lenovo.xiaoshixun1.bean.Bean;
import com.example.lenovo.xiaoshixun1.callback.CallBack;
import com.example.lenovo.xiaoshixun1.model.MyModel;

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
    public void onFail(String stirng) {
        if (myView != null) {
            myView.onFail(stirng);
        }
    }
}
