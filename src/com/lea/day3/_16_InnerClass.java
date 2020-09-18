package com.lea.day3;

/**
 * @author aCheng
 * @create 2020/8/14 23:27
 *
 *  1.java中允许将一个类A声明在另一个类B中，则类A就是内部类，B就是外部类
 *
 *  2. 内部类的分类，成员内部类（静态、非静态的） vs 局部内部类（方法内、代码块内、构造器内）
 *
 *  3. 成员内部类
 *       一方面、作为外部类的成员；
 *          > 调用外部类的结构
 *          > 可以被static修饰
 *          > 可以被四种不同的权限修饰
 *
 *       另一方面，作为一个类：
 *          > 类内可以定义属性、方法、构造器等
 *          > 可以被final修饰 表示此类不能被继承，言外之意、不使用final， 则可以被继承
 *          > 可以被abstract修饰
 */
public class _16_InnerClass {


    public static void main(String[] args) {
        // 创建Dog的实例（静态成员类实例）
        Person1.Dog dog = new Person1.Dog();
        // 创建DD实例（成员类实例）
        Person1.DD dd = new Person1().new DD();
    }
}

class Person1{
    // 静态成员内部类
    static class Dog{

    }
    // 成员内部类
    class DD{

    }

    public void method() {
        // 局部内部类
        class Dog{

        }
    }

    {// 局部内部类
        class Dog{

        }
    }

    public Person1() {
        // 局部内部类
        class Dog{}
    }
}
