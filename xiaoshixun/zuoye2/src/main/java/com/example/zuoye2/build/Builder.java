package com.example.zuoye2.build;

/**
 * @author xts
 *         Created by asus on 2019/4/1.
 */

public abstract class Builder {
    public abstract Builder buildBoard(String board);
    public abstract Builder buildDisplay(String display);
    public abstract Builder buildOs();
    public abstract Computer build();
}
