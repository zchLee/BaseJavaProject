package com.lea.day3;

import java.util.Arrays;

/**
 * @author aCheng
 * @create 2020/8/11 17:10
 *
 * 单例模式  整个软件系统中，某个类只能存在一个实例
 *   需要将构造器的访问权限设置为private，这样就不能用new操作符在类的外部产生类的对象了，但在类内部仍可以产生
 *   该类的对象。
 *   再通过静态方法以返回内部产生的对象，静态方法只能访问类中的静态成员变量，所以类内部产生的该类对象的变量只能定义为static静态的
 *
 *   饿汉模式 vs 懒汉模式
 *   饿汉：线程安全但类加载时间长
 *   懒汉: 延迟对象的创建但是线程不安全（双重检测可以保证线程安全）
 */
public class _11_Singleton {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
    }

}

// 饿汉模式
class Singleton1 {

    private Singleton1(){}

    private static Singleton1 instantce = new Singleton1();

    public static Singleton1 getInstance(){
        return instantce;
    }
}

// 懒汉模式
class Singleton2 {

    private Singleton2(){}

    private static Singleton2 instantce = null;

    public static Singleton2 getInstance(){
        if (null == instantce)
            instantce = new Singleton2();
        return instantce;
    }

    // 线程安全 双重检测的懒汉模式
    public static Singleton2 doubleCheckGetInstance(){
        if (null == instantce) {
            synchronized (Singleton2.class) {
                if (null == instantce) {
                    instantce = new Singleton2();
                }
            }
        }
        return instantce;
    }
}
