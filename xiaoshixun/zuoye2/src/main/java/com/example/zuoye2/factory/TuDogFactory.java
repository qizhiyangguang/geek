package com.example.zuoye2.factory;

/**
 * @author xts
 *         Created by asus on 2019/4/1.
 */

public class TuDogFactory extends Factory {
    @Override
    public Dog createDog() {
        return new TuDog();
    }
}
