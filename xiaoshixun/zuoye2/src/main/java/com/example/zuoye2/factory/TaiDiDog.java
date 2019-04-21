package com.example.zuoye2.factory;

import android.util.Log;

/**
 * @author xts
 *         Created by asus on 2019/4/1.
 */

public class TaiDiDog extends Dog {
    private static final String TAG = "TaiDiDog";

    @Override
    public void eat() {
        Log.d(TAG, "泰迪舔着吃");
    }
}
