package com.example.lenovo.xiaoshixun1.callback;

import com.example.lenovo.xiaoshixun1.bean.Bean;

public interface CallBack {
    void onSuccess(Bean bean);

    void onFail(String stirng);
}
