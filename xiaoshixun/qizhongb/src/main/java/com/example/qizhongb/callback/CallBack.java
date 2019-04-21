package com.example.qizhongb.callback;

import com.example.qizhongb.bean.Bean;

public interface CallBack {
    void onSuccess(Bean bean);

    void onFail(String string);
}
