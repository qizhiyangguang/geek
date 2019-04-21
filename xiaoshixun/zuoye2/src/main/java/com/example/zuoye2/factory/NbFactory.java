package com.example.zuoye2.factory;

/**
 * @author xts
 *         Created by asus on 2019/4/1.
 */

public class NbFactory extends SuperFactory {
    @Override
    public <T extends Dog> T createDog(Class<T> clz) {
        //newInstance() 相当于new T();
        T dog = null;
        try {
           dog  = (T) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dog;
    }
}
