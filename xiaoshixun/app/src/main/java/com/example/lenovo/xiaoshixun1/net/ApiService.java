package com.example.lenovo.xiaoshixun1.net;

import com.example.lenovo.xiaoshixun1.bean.Bean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    //https://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1
    String url = "https://gank.io/api/data/%E7%A6%8F%E5%88%A9/";

    @GET("10/{page}")
    Observable<Bean> getData(@Path("page") int page);
}
