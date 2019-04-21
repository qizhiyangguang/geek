package com.example.zuoye2.single;

public class SingleTon2 {
    private static SingleTon2 singleTon;
    //私有构造

    private SingleTon2() {
    }

    public static SingleTon2 getInstance() {
        //线程不安全，有可能会创建出多个对象来
        //线程1，2线程
        if (singleTon == null) {
            singleTon = new SingleTon2();
        }
        return singleTon;
    }
}
