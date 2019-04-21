package com.example.qizhonga.callback;

import com.example.qizhonga.bean.BBean;
import com.example.qizhonga.bean.Bean;

public interface CallBack {
    void onSuccess(Bean bean);
    void onFail(String str);
}
