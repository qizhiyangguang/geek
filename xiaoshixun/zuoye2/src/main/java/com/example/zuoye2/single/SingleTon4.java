package com.example.zuoye2.single;

public class SingleTon4 {


    private SingleTon4() {
    }

    public static SingleTon4 getInstance() {
        return ViewHolder.singleTon;
    }

    private static class ViewHolder {
        private static SingleTon4 singleTon = new SingleTon4();
    }
}
