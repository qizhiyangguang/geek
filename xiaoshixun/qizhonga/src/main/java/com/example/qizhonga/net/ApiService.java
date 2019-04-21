package com.example.qizhonga.net;

import com.example.qizhonga.bean.BBean;
import com.example.qizhonga.bean.Bean;
import com.example.qizhonga.bean.MeiNvBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //http://www.wanandroid.com/article/list/0/json
    //http://www.wanandroid.com/project/list/1/json?cid=402
    //https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
    String url="http://www.wanandroid.com/";
    String meiNv="https://gank.io/api/data/%E7%A6%8F%E5%88%A9/";
    @GET("article/list/0/json")
    Observable<Bean> getData1();
    @GET("project/list/1/json?cid=402")
    Observable<BBean> getData2();
    @GET("10/{page}")
    Observable<MeiNvBean> getHttp(@Path("page") int page);
}
