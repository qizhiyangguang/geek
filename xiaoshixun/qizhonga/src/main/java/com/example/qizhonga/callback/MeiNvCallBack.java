package com.example.qizhonga.callback;

import com.example.qizhonga.bean.MeiNvBean;

public interface MeiNvCallBack {
    void onSuccess(MeiNvBean bean);
    void onFail(String string);
}
