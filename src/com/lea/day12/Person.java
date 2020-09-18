package com.lea.day12;

/**
 * @author aCheng
 * @create 2020/09/10 下午 1:55
 */
public class Person {

    private String name;

    public int age;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void show() {
        System.out.println("这是一个人");
    }

    private void showNation(String nation) {
        System.out.println("这个人来自" + nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
