package com.example.gekk.model;

import android.util.Log;

import com.example.gekk.base.BaseModel;
import com.example.gekk.bean.LoginBean;
import com.example.gekk.net.ApiService;
import com.example.gekk.net.ResultCallBack;


import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainM extends BaseModel {
    public void login(String name, String psd, final ResultCallBack callBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Observable<LoginBean> data = apiService.login(name, psd);
        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
//切断观察者和被观察者的链接，找到合适的机会，界面推出的时候
                        Log.d("tag", "");
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(LoginBean bean) {
                        callBack.onSuccess(bean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callBack.onFail(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
