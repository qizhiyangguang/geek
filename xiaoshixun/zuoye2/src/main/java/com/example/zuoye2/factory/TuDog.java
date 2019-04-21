package com.example.zuoye2.factory;

import android.util.Log;

/**
 * @author xts
 *         Created by asus on 2019/4/1.
 */

public class TuDog extends Dog {
    private static final String TAG = "TuDog";

    @Override
    public void eat() {
        Log.d(TAG, "土狗改不了吃....");
    }
}
