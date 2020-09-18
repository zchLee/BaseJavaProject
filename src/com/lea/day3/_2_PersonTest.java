package com.lea.day3;

/**
 * @author a cheng
 * @create 2020/8/1 23:21
 */

/**
 * 设计类就是设计类的成员
 *
 * 属性 = field = 成员你变量
 * 方法 = method = 函数
 */
public class _2_PersonTest {

    public static void main(String[] args) {
        // 创建类的对象 = 类的实例化 = 实例化类
        Person person = new Person();
        person.eat("北京烤鸭");
        person.sleep();

        // 创建对象时，没有显示的赋给一个变量名。即为匿名对象
        // 匿名对象只能被调用一次（r如果使用了工厂模式、构造者模式例外）
        new Person().sleep();
    }
}


class Person{
    // 属性
    String name;
    int age;
    boolean isMale;

    // 方法
    public void eat(String food){
        System.out.println("吃" + food);
    }

    public void sleep(){
        System.out.println("睡觉");
    }

}