package com.example.zuoye2.single;

public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    //私有构造

    private SingleTon() {
    }

    public static SingleTon getInstance() {
        return singleTon;
    }
}
