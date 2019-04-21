package com.example.gekk.base;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

public class BaseApp extends Application{
    private static BaseApp app;
    //默认不是夜间模式
    public  static int mModel= AppCompatDelegate.MODE_NIGHT_NO;
    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    public static BaseApp getApp() {
        return app;
    }
}
