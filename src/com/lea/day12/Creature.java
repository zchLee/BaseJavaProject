package com.lea.day12;

import java.io.Serializable;

/**
 * @author aCheng
 * @create 2020/09/10 下午 5:44
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }
}
