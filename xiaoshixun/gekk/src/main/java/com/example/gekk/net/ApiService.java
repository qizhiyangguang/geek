package com.example.gekk.net;



import com.example.gekk.bean.LoginBean;

import io.reactivex.Observable;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    String url = "http://yun918.cn/study/public/index.php/";

    @FormUrlEncoded
    @POST("login")
    Observable<LoginBean> login(@Field("username") String name, @Field("password") String psd);
}
