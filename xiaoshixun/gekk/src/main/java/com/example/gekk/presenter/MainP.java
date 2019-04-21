package com.example.gekk.presenter;

import android.text.TextUtils;

import com.example.gekk.base.BasePresenter;
import com.example.gekk.bean.LoginBean;
import com.example.gekk.model.MainM;
import com.example.gekk.net.ResultCallBack;
import com.example.gekk.utils.Logger;
import com.example.gekk.view.MainView;

public class MainP extends BasePresenter<MainView> {

    private MainM mainM;

    public void getData() {
        //获取数据，假设数据网络来的
        String data = "网络回来的数据";
        if (mView != null) {
            mView.setData(data);
        }
    }

    public void login() {
        String name = mView.getUserName();
        String psd = mView.getPsd();
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(psd)) {
            mView.showToast("用户名或者密码不能为空");
            return;
        }
        //进行网络请求，去登陆M
        mainM.login(name, psd, new ResultCallBack() {
            @Override
            public void onSuccess(LoginBean bean) {
                if (bean != null) {
                    Logger.logD("tag", bean.toString());
                    if (bean.getCode() == 200) {
                        //防止页面销毁，数据返回后设置页面的时空指针
                        if (mView != null) {
                            mView.showToast("登陆成功");
                        }
                    } else {
                        if (mView != null) {
                            mView.showToast("登陆失败");
                        }
                    }
                }
            }

            @Override
            public void onFail(String msg) {
                Logger.logD("tag", msg);
                if (mView != null) {
                    mView.showToast("登陆失败");
                }
            }
        });
    }

    @Override
    protected void initModel() {
        mainM = new MainM();
        models.add(mainM);
    }
}
