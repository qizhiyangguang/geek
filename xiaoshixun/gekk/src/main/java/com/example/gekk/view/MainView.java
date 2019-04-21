package com.example.gekk.view;

import com.example.gekk.base.BaseMvpView;

public interface MainView extends BaseMvpView {
    void setData(String data);

    String getUserName();

    String getPsd();

    void showToast(String msg);
}
