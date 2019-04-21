package com.example.qizhongb.net;

import com.example.qizhongb.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    //http://www.wanandroid.com/project/list/1/json?cid=402
    String url = "http://www.wanandroid.com/project/";

    @GET("list/{page}/json?cid=402")
    Observable<Bean> getData(@Path("page") int page);
}
