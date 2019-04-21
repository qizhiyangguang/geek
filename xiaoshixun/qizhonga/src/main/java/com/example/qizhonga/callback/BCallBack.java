package com.example.qizhonga.callback;

import com.example.qizhonga.bean.BBean;
import com.example.qizhonga.bean.Bean;

public interface BCallBack {
    void onSuccess(BBean bean);
    void onFail(String string);
}
