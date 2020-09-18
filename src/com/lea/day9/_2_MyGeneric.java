package com.lea.day9;

/**
 * @author aCheng
 * @create 2020/09/02 上午 10:24
 */
public class _2_MyGeneric<T> {

    String name;

    int age;

    T t;

    public _2_MyGeneric() { }

    public _2_MyGeneric(String name, int age, T t) {
        this.name = name;
        this.age = age;
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "_2_MyGeneric{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", t=" + t +
                '}';
    }
}
