package com.example.qizhonga.view;

import com.example.qizhonga.bean.BBean;

public interface BView {
    void onSuccess(BBean bean);
    void onFail(String string);
}
