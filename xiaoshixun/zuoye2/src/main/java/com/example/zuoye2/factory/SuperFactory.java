package com.example.zuoye2.factory;

/**
 * @author xts
 *         Created by asus on 2019/4/1.
 */

public abstract class SuperFactory {
    public abstract <T extends Dog> T createDog(Class<T> clz);
}
