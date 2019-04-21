package com.example.gekk.net;

import com.example.gekk.bean.LoginBean;

public interface ResultCallBack {
    void onSuccess(LoginBean bean);

    void onFail(String msg);
}
