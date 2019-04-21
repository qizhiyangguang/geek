package com.example.zuoye2.build;

import android.net.Uri;

/**
 * @author xts
 *         Created by asus on 2019/4/1.
 */

public abstract class Computer {
    protected String mBoard;
    protected String mDisplay;
    protected String mOs;

    public void setBoard(String board){
        this.mBoard = board;
    }

    public void setDisplay(String display){
        this.mDisplay = display;
    }

    public abstract void setOs();

    @Override
    public String toString() {
        return "Computer{" +
                "mBoard='" + mBoard + '\'' +
                ", mDisplay='" + mDisplay + '\'' +
                ", mOs='" + mOs + '\'' +
                '}';
    }
}
