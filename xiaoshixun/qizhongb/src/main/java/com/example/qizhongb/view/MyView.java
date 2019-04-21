package com.example.qizhongb.view;

import com.example.qizhongb.bean.Bean;

public interface MyView {
    void onSuccess(Bean bean);

    void onFail(String string);
}
