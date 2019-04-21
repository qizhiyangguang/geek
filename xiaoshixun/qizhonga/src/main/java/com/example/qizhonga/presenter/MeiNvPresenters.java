package com.example.qizhonga.presenter;

import com.example.qizhonga.bean.MeiNvBean;
import com.example.qizhonga.callback.MeiNvCallBack;
import com.example.qizhonga.model.MeiNvModel;
import com.example.qizhonga.view.MeiNvView;

public class MeiNvPresenters implements MeiNvPresenter, MeiNvCallBack {
    private MeiNvModel meiNvModel;
    private MeiNvView meiNvView;

    public MeiNvPresenters(MeiNvModel meiNvModel, MeiNvView meiNvView) {
        this.meiNvModel = meiNvModel;
        this.meiNvView = meiNvView;
    }

    @Override
    public void getHttp(int page) {
if (meiNvModel!=null){
    meiNvModel.getHttp(page,this);
}
    }

    @Override
    public void onSuccess(MeiNvBean bean) {
        if (meiNvView != null) {
            meiNvView.onSuccess(bean);
        }
    }

    @Override
    public void onFail(String string) {
        if (meiNvView != null) {
            meiNvView.onFail(string);
        }
    }


}
