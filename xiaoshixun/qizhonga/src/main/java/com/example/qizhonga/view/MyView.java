package com.example.qizhonga.view;

import com.example.qizhonga.bean.BBean;
import com.example.qizhonga.bean.Bean;

public interface MyView {
    void onSuccess(Bean bean);
    void onFail(String string);
}
