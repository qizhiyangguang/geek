package com.example.zuoye2.obser;

import java.util.Observable;

public class DuZhe extends Observable {
    public void postNews(String content) {
        //标记状态发生改变
        setChanged();
        //通知所有的观察者
        notifyObservers(content);
    }
}
