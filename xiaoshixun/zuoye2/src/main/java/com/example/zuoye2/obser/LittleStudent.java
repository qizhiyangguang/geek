package com.example.zuoye2.obser;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

public class LittleStudent implements Observer {
    private final String mName;

    public LittleStudent(String name) {
        this.mName = name;
    }

    /**
     * 一旦被观察者调用 notifyObservers(),这个update方法就会被调用
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {
        Log.d("tag", "小学生: " + mName + "收到了消息:" + arg);
    }
}
