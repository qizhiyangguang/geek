package com.example.zuoye2.single;

public class SingleTon3 {
    //volatile避免DCL失效问题
    private static volatile SingleTon3 singleTon;
    //私有构造

    private SingleTon3() {
    }

    //每次都要同步
    public static SingleTon3 getInstance() {
        //避免不必要的同步的
        if (singleTon == null) {
            synchronized (SingleTon3.class) {
                if (singleTon == null) {
                    singleTon = new SingleTon3();
                }
            }
        }
        return singleTon;
    }
}
